package com.wanted.cleanarchitecture.enrollment.application.policy;

import com.wanted.cleanarchitecture.enrollment.application.port.CourseCatalogPort;
import com.wanted.cleanarchitecture.enrollment.application.port.CoursePublicationStatus;
import com.wanted.cleanarchitecture.enrollment.domain.repository.EnrollmentRepository;
import com.wanted.cleanarchitecture.global.domain.common.exception.DomainRuleViolationException;
import org.springframework.stereotype.Component;

/*
 * EnrollmentEligibilityPolicy 는 수강 신청 가능 여부를 판단하는 Application Policy 다.
 *
 * 왜 Enrollment Aggregate 가 아니라 Policy 인가?
 * - 이미 활성 수강이 있는지 확인하려면 EnrollmentRepository 조회가 필요하다.
 * - 강의가 공개 상태인지 확인하려면 catalog 컨텍스트 조회가 필요하다.
 * - 즉, Enrollment 하나의 내부 상태만으로 판단할 수 없는 규칙이다.
 *
 * G1) 검증 1 : catalog 컨텍스트에서 조회 필요 -> policy,
 *  검증 2: DB 에서 기존 수강 조회 필요 -> policy,
 *  중복 완료 방지 : 자기 status 만 확인하면 됨 -> domain
 *
 * Bounded Context 호출 흐름:
 * EnrollmentCommandService
 *   -> EnrollmentEligibilityPolicy
 *      -> CourseCatalogPort
 *         -> CatalogCourseAdapter
 *            -> CourseRepository
 *
 * 중요한 점:
 * enrollment 는 catalog 의 Course Aggregate 전체를 직접 사용하지 않는다.
 * 수강 신청에 필요한 것은 "강의가 공개되었는가?"라는 작은 사실뿐이므로
 * CoursePublicationStatus 라는 작은 응답 모델만 사용한다.
 */
@Component
public class EnrollmentEligibilityPolicy {

    private final CourseCatalogPort courseCatalogPort;
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentEligibilityPolicy(
            CourseCatalogPort courseCatalogPort,
            EnrollmentRepository enrollmentRepository
    ) {
        this.courseCatalogPort = courseCatalogPort;
        this.enrollmentRepository = enrollmentRepository;
    }

    // G1) 1단계 검증 : catalog 컨텍스트에 강의 공개 여부를 물어봄
    public void ensureEligible(Long userId, Long courseId) {
        CoursePublicationStatus course = courseCatalogPort.getPublicationStatus(courseId);

        if (!course.published()) {
            throw new DomainRuleViolationException("Only published courses can be enrolled.");
        }

        // G1) 2단계 검증 : 수강 여부 물어봄
        if (enrollmentRepository.existsActiveEnrollment(userId, courseId)) {
            throw new DomainRuleViolationException("Active enrollment already exists.");
        }
    }
}
