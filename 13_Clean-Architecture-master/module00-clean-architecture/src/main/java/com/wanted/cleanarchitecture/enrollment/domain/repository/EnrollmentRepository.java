package com.wanted.cleanarchitecture.enrollment.domain.repository;

import com.wanted.cleanarchitecture.enrollment.domain.model.Enrollment;

import java.util.Optional;

/*
 * EnrollmentRepository 는 enrollment context 의 repository port 다.
 * application/domain 은 "활성 수강 존재 여부" 같은 비즈니스에 필요한 조회만 의존하고,
 * 실제 SQL 이나 JPA 방식은 adapter 로 밀어낸다.
 */
public interface EnrollmentRepository {

    Enrollment save(Enrollment enrollment);

    Optional<Enrollment> findById(Long enrollmentId);

    // G1) 이미 수강 중인 강의 여부 확인
    boolean existsActiveEnrollment(Long userId, Long courseId);

    Optional<Enrollment> findActiveEnrollment(Long userId, Long courseId);
}
