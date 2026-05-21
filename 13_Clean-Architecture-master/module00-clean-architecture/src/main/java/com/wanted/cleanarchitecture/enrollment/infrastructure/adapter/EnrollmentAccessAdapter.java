package com.wanted.cleanarchitecture.enrollment.infrastructure.adapter;

import com.wanted.cleanarchitecture.enrollment.domain.repository.EnrollmentRepository;
import com.wanted.cleanarchitecture.learning.application.port.EnrollmentAccessPort;
import org.springframework.stereotype.Component;

@Component
// G1) learning 의 port 를 enrollment 인프라에서 구현
public class EnrollmentAccessAdapter implements EnrollmentAccessPort {

    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentAccessAdapter(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public boolean hasActiveEnrollment(Long userId, Long courseId) {
        return enrollmentRepository.existsActiveEnrollment(userId, courseId);
    }
}
