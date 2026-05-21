package com.wanted.cleanarchitecture.learning.domain.repository;

import com.wanted.cleanarchitecture.learning.domain.model.LearningProgress;

import java.util.Optional;

/*
 * LearningProgressRepository 는 learning context 의 출력 포트다.
 * 진행 기록 저장 방식은 숨기고, 유스케이스가 필요한 저장/조회 계약만 노출한다.
 */
// G1) Domain 의 포트
public interface LearningProgressRepository {

    LearningProgress save(LearningProgress progress);

    Optional<LearningProgress> findById(Long progressId);

    // G1) userId + moduleId 조합으로 조회, 한 유저가 같은 모듈 중복 완료 못하게 찾는 용도
    Optional<LearningProgress> findByUserIdAndModuleId(Long userId, Long moduleId);
}
