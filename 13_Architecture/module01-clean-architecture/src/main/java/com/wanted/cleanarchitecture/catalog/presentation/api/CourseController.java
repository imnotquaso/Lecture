package com.wanted.cleanarchitecture.catalog.presentation.api;

import com.wanted.cleanarchitecture.catalog.application.command.CreateCourseCommand;
import com.wanted.cleanarchitecture.catalog.application.usecase.CourseCommandUseCase;
import com.wanted.cleanarchitecture.catalog.application.usecase.CourseQueryUseCase;
import com.wanted.cleanarchitecture.catalog.presentation.api.request.CreateCourseRequest;
import com.wanted.cleanarchitecture.catalog.presentation.api.response.CreateCourseResponse;
import com.wanted.cleanarchitecture.global.presentation.common.ApiResponse;
import com.wanted.cleanarchitecture.global.presentation.common.ApiResponseCode;
import com.wanted.cleanarchitecture.global.presentation.common.ApiResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    // G1) CourseCommandService 가 아닌 CourseCommandUseCase 를 상속 받음
    // command(dml)
    private final CourseCommandUseCase courseCommandUseCase;
    // query(read)
    private final CourseQueryUseCase courseQueryUseCase;

    @PostMapping
    public ResponseEntity<ApiResponse<CreateCourseResponse>> createCourse(
            // G1) 클라이언트가 보낸 JSON 을 CreateCourseRequest 객체로 자동 변환
            @RequestBody CreateCourseRequest request) {

        // G1) CreateCourseRequest 의 데이터를 command 로 변환
        //  계층이 서로 모르게 하기 위함 (command 는 순수 자바)
        Long courseId = courseCommandUseCase.handle(new CreateCourseCommand(
                // G1) record 는 getter 대신 request 로 받음
                request.authorId(),
                request.title(),
                request.description()
        ));

        // G1) Controller 응답 반환
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.created(
                        ApiResponseCode.COURSE_CREATED,
                        ApiResponseMessage.COURSE_CREATED,
                        new CreateCourseResponse(courseId)
                ));

    }

    @GetMapping("/{courseId}")
    public ResponseEntity<ApiResponse<CourseQueryUseCase.CourseView>> getCourse(@PathVariable Long courseId) {

        return ResponseEntity.ok(ApiResponse.success(
                ApiResponseCode.SUCCESS,
                ApiResponseMessage.SUCCESS,
                courseQueryUseCase.handle(courseId)
        ));

    }

}
