package com.wanted.cleanarchitecture.learning.application.command;

/*
 * CompleteModuleCommand 는 학습 진행 문맥에서 "모듈 완료" 요청을 담는 Command 다.
 * learning context 는 catalog 의 강의 정의를 소비하는 쪽이며, 이 Command 는 그 실행 흐름의 시작점이다.
 */
public record CompleteModuleCommand(
        Long userId,
        Long courseId,
        Long moduleId
) {
}
