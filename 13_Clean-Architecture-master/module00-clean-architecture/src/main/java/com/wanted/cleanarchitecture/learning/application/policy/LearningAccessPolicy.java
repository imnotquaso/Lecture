package com.wanted.cleanarchitecture.learning.application.policy;

import com.wanted.cleanarchitecture.enrollment.domain.repository.EnrollmentRepository;
import com.wanted.cleanarchitecture.global.domain.common.exception.DomainRuleViolationException;
import com.wanted.cleanarchitecture.learning.application.port.EnrollmentAccessPort;
import org.springframework.stereotype.Component;

/*
 * LearningAccessPolicy 는 학습 진행 가능 여부를 판단하는 Application Policy 다.
 *
 * 현재 코드는 수업 실습을 위해 일부러 enrollment 의 Repository 를 직접 사용한다.
 * 앞에서 완성한 CourseCatalogPort 예제를 참고해 다음 단계에서
 * learning.application.port.EnrollmentAccessPort 로 분리해보면 된다.
 *
 * TODO:
 * - EnrollmentRepository 직접 의존을 제거한다.
 * - EnrollmentAccessPort 를 주입받는다.
 * - "활성 수강이 있는가?"라는 결과만 사용하도록 바꾼다.
 */
@Component
public class LearningAccessPolicy {

    // G1) learning 패키지가 enrollment 의 Repository 를 알고 있는 문제점 🚨
    //  완전히 다른 컨텍스트의 내부를 직접 참조하기 위해서는 PORT 필요
//    private final EnrollmentRepository enrollmentRepository;

    private final EnrollmentAccessPort enrollmentAccessPort;

//    public LearningAccessPolicy(EnrollmentRepository enrollmentRepository) {
//        this.enrollmentRepository = enrollmentRepository;
//    }

    public LearningAccessPolicy(EnrollmentAccessPort enrollmentAccessPort) {
        this.enrollmentAccessPort = enrollmentAccessPort;
    }

    public void ensureModuleCompletable(Long userId, Long courseId) {
            if (!enrollmentAccessPort.hasActiveEnrollment(userId, courseId)) {
                throw new DomainRuleViolationException(
                        "Active enrollment is required before learning."
                );
            }
    }

//    public void ensureModuleCompletable(Long userId, Long courseId) {
//        enrollmentRepository.findActiveEnrollment(userId, courseId)
//                .orElseThrow(() -> new DomainRuleViolationException("Active enrollment is required before learning."));
//    }
}
