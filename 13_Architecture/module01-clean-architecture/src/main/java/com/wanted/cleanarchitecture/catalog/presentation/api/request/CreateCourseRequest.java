package com.wanted.cleanarchitecture.catalog.presentation.api.request;

public record CreateCourseRequest(
        // G1) 클라이언트가 보낸 JSON body 내용
        Long authorId,
        String title,
        String description
) {
}
