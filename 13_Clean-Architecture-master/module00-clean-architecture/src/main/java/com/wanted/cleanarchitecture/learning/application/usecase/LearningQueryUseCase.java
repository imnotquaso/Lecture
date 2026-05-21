package com.wanted.cleanarchitecture.learning.application.usecase;

import java.time.Instant;

public interface LearningQueryUseCase {

    LearningProgressView handle(Long progressId);

    // G1) LearningProgressView 는 UseCase 전용 응답 모델이기 때문에, 다른 곳에서 쓸 일이 없기 때문에
    //  UseCase 안에 묶어 응집도를 높임 -> LearningQueryUseCase.LearningProgressView 접근
    record LearningProgressView(
            Long progressId,
            Long userId,
            Long moduleId,
            String status,
            Instant completedAt
    ) {
    }
}
