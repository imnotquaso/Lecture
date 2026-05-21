package com.wanted.cleanarchitecture.learning.application.service;

import com.wanted.cleanarchitecture.learning.application.command.CompleteModuleCommand;
import com.wanted.cleanarchitecture.learning.application.policy.LearningAccessPolicy;
import com.wanted.cleanarchitecture.learning.application.usecase.LearningCommandUseCase;
import com.wanted.cleanarchitecture.learning.domain.model.LearningProgress;
import com.wanted.cleanarchitecture.learning.domain.repository.LearningProgressRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 * [Application Service 역할]
 * - 트랜잭션 경계 안에서 Policy 검증 + Entity 상태 전이 + 저장을 오케스트레이션한다.
 * - 규칙 구현은 Entity/Policy 에 두고, Service 는 실행 순서와 경계에 집중한다.
 */
@Service
@Transactional
public class LearningCommandService implements LearningCommandUseCase {

    private final LearningProgressRepository learningProgressRepository;
    private final LearningAccessPolicy learningAccessPolicy;

    public LearningCommandService(
            LearningProgressRepository learningProgressRepository,
            LearningAccessPolicy learningAccessPolicy
    ) {
        this.learningProgressRepository = learningProgressRepository;
        this.learningAccessPolicy = learningAccessPolicy;
    }

    @Override
    // G1) Policy 실행 끝나면, LearningProgress 조회로 넘어감
    public void handle(CompleteModuleCommand command) {
        // G1) 수강 중인지 먼저 확인
        learningAccessPolicy.ensureModuleCompletable(command.userId(), command.courseId());

        // G1) 진행 기록 조회 (없으면 새로 시작)
        LearningProgress progress = learningProgressRepository
                .findByUserIdAndModuleId(command.userId(), command.moduleId())
                .orElseGet(() -> LearningProgress.start(command.userId(), command.moduleId()));
        // G1) orElseGet() : 없으면 람다 실행해서 새로 만듦 / orElseThrow() : 없으면 예외 터트림

        // G1) 완료 처리
        progress.complete();
        // G1) 저장(adapter 실행)
        learningProgressRepository.save(progress);
}
}







