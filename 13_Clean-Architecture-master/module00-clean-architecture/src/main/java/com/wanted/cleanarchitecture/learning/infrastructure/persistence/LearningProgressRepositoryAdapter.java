package com.wanted.cleanarchitecture.learning.infrastructure.persistence;

import com.wanted.cleanarchitecture.learning.domain.model.LearningProgress;
import com.wanted.cleanarchitecture.learning.domain.model.ProgressStatus;
import com.wanted.cleanarchitecture.learning.domain.repository.LearningProgressRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/*
 * LearningProgressRepositoryAdapter 는 learning context 의 repository port 구현체다.
 * 저장소 세부 구현을 바깥 계층에 묶어두고, 안쪽 계층에는 순수 domain model 만 넘긴다.
 */
@Repository
@Transactional
// G1) Domain 의 PORT 를 JPA 로 구현하는 Adapter
public class LearningProgressRepositoryAdapter implements LearningProgressRepository {

    private final SpringDataLearningProgressRepository repository;

    public LearningProgressRepositoryAdapter(SpringDataLearningProgressRepository repository) {
        this.repository = repository;
    }

    @Override
    public LearningProgress save(LearningProgress progress) {
        LearningProgressJpaEntity entity = progress.getId() == null
                ? new LearningProgressJpaEntity(
                        progress.getUserId(),
                        progress.getModuleId(),
                        progress.getStatus().name().toLowerCase(),
                        progress.getCompletedAt()
                )
                : repository.findById(progress.getId()).orElseThrow();

        // G1) 도메인의 현재 상태를 JpaEntity 에 반영
        entity.changeStatus(progress.getStatus().name().toLowerCase());
        entity.changeCompletedAt(progress.getCompletedAt());

        // G1) Jpa 를 DB 에 저장
        LearningProgressJpaEntity saved = repository.save(entity);
        // G1) JpaEntity -> 도메인 객체로 역변환
        return toDomain(saved);
    }

    @Override
    // G1) 조회 : readOnly = true
    @Transactional(readOnly = true)
    public Optional<LearningProgress> findById(Long progressId) {
        // G1) map() 안의 값을 toDomain() 으로 변환
        return repository.findById(progressId).map(this::toDomain);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<LearningProgress> findByUserIdAndModuleId(Long userId, Long moduleId) {
        // G1) SpringData JPA 쿼리 메서드 호출, 결과 JpaEntity 를 Domain 으로 변환
        return repository.findByUserIdAndModuleId(userId, moduleId).map(this::toDomain);
    }

    private LearningProgress toDomain(LearningProgressJpaEntity entity) {
        return LearningProgress.restore(
                entity.getId(),
                entity.getUserId(),
                entity.getModuleId(),
                ProgressStatus.valueOf(entity.getStatus().toUpperCase()),
                entity.getCompletedAt()
        );
    }
}
