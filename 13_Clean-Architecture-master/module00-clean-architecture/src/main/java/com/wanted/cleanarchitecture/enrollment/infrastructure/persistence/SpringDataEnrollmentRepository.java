package com.wanted.cleanarchitecture.enrollment.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*
 * SpringDataEnrollmentRepository 는 infrastructure 내부에서만 사용하는 기술 저장소다.
 * domain port 를 직접 구현하지 않고, adapter 가 이 기술 저장소를 감싸는 구조를 의도적으로 보여준다.
 */
// G1) JPA 쿼리 메서드
public interface SpringDataEnrollmentRepository extends JpaRepository<EnrollmentJpaEntity, Long> {

    // G1) 메서드 이름만으로 쿼리 자동 생성
    //  SELECT EXISTS (WHERE user_id = ? AND course_id ? AND status = ?)
    boolean existsByUserIdAndCourseIdAndStatus(Long userId, Long courseId, String status);

    Optional<EnrollmentJpaEntity> findByUserIdAndCourseIdAndStatus(Long userId, Long courseId, String status);
}
