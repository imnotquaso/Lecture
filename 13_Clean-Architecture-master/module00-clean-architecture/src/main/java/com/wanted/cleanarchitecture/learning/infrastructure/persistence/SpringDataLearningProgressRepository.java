package com.wanted.cleanarchitecture.learning.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*
 * SpringDataLearningProgressRepository 는 infrastructure 내부 기술 저장소다.
 * application/domain 은 이 타입을 직접 의존하지 않고 adapter 뒤에 숨긴다.
 */
// G1) JpaRepository 를 상속받으면 기본 crud 사용 가능
public interface SpringDataLearningProgressRepository extends JpaRepository<LearningProgressJpaEntity, Long> {

    // G1) 메소드 이름 규칙으로 쿼리 자동 생성
    Optional<LearningProgressJpaEntity> findByUserIdAndModuleId(Long userId, Long moduleId);
}
