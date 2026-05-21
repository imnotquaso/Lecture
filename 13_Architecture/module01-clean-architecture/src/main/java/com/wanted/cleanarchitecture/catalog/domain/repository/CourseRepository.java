package com.wanted.cleanarchitecture.catalog.domain.repository;

import com.wanted.cleanarchitecture.catalog.domain.model.Course;

import java.util.Optional;

public interface CourseRepository {

    // G1) Course 만 알고, JPA 는 모름
    Course save(Course newCourse);

    // 강의 상세 조회
    Optional<Course> findById(Long courseId);
}
