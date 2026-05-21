package com.wanted.cleanarchitecture.catalog.application.usecase;

// G1) Query : 조회, Command : 명령
//  query : mybatis, command : jpa
public interface CourseQueryUseCase {

    // 강의 상세 조회 유스케이스
    CourseView handle(Long courseId);

    // G1) api 명세를 바탕으로 필드 구성
    // 강의 상세 조회 시 응답 사용 객체
    record CourseView(
            Long courseId,
            Long authorId,
            String title,
            String description,
            String status,
            int sectionCount,
            int moduleCount
    ) {}

}
