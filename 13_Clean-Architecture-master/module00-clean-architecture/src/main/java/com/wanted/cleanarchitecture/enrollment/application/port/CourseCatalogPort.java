package com.wanted.cleanarchitecture.enrollment.application.port;

/*
 * CourseCatalogPort 는 enrollment 컨텍스트가 catalog 컨텍스트에 기대는 "필요 최소 계약"이다.
 *
 * 수강 신청에는 Course Aggregate 전체가 필요하지 않다.
 * 필요한 것은 "해당 강의가 공개 상태인가?"라는 사실이다.
 *
 * 따라서 enrollment 는 catalog.domain.model.Course 를 직접 알지 않고,
 * 이 Port 를 통해 자기 유스케이스에 필요한 정보만 요청한다.
 */
// G1) enrollment 컨텍스트 소속 인터페이스
public interface CourseCatalogPort {

    // G1) 공개 강의 여부 인지 확인
    CoursePublicationStatus getPublicationStatus(Long courseId);
}
