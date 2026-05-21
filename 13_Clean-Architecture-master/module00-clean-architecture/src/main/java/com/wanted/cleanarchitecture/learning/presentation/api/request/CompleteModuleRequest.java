package com.wanted.cleanarchitecture.learning.presentation.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

// G1) Swagger 자동 생성용 어노테이션
@Schema(description = "모듈 완료 처리 요청")
public record CompleteModuleRequest(
        @Schema(description = "학습자 사용자 ID", example = "200")
        @NotNull Long userId, // G1) @valid <- null 이면 400 에러 발생

        @Schema(description = "모듈이 속한 강의 ID", example = "1")
        @NotNull Long courseId
) {
}
