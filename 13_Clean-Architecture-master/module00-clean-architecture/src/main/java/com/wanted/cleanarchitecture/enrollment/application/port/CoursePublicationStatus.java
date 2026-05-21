package com.wanted.cleanarchitecture.enrollment.application.port;

/*
 * CoursePublicationStatus 는 enrollment 컨텍스트가 catalog 에서 받아오는 작은 응답 모델이다.
 *
 * Course 의 제목, 설명, 섹션, 모듈 구조는 수강 신청 규칙에 필요하지 않다.
 * 이렇게 필요한 값만 담으면 Bounded Context 사이의 결합을 줄일 수 있다.
 */
// G1) 필요한 것만 담은 최소 응답 모델
//  바운디드 컨텍스트 응답을 최소화
public record CoursePublicationStatus(
        Long courseId,
        boolean published
) {
}
