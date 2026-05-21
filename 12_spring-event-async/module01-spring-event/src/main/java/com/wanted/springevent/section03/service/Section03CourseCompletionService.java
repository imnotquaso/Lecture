package com.wanted.springevent.section03.service;

import com.wanted.springevent.enrollment.entity.Enrollment;
import com.wanted.springevent.enrollment.repository.EnrollmentRepository;
import com.wanted.springevent.section03.event.Section03CourseCompletedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class Section03CourseCompletionService {

    private final EnrollmentRepository enrollmentRepository;
    // Event 발행자
    private final ApplicationEventPublisher publisher;

    // 생성자로 의존성 주입
    // jj) 수료증 관련 의존성 제거, EventPublisher 의존성 주입
    public Section03CourseCompletionService(
            EnrollmentRepository enrollmentRepository,
            ApplicationEventPublisher publisher
    ) {
        this.enrollmentRepository = enrollmentRepository;
        this.publisher = publisher;
    }

    /*
    * comment.
    *  Section03 의 실행 시나리오
    *  publishEvent() 를 호출하는 시점은 @Transactional 내부에 감싸져 있다.
    *  단순히 이벤트를 분리하고 끝내는 것이 아닌, 후속 작업(Event) 의 실행 시점을 제어하는 것이 중요하다.
    *  DB Commit 이 된 이후에 실행이 되어야 안전한 Event 작업은
    *  @TransactionalEventListener(AFTER_COMMIT) 으로 분리한다.
    * */

    @Transactional
    public void completeCourse(Long enrollmentId) {

        // User, Course 정보를 enrollmentId 로 판단하여 수강이 완료됨을 처리할 것이다.
        Enrollment enrollment = enrollmentRepository.findWithUserAndCourseByEnrollmentId(enrollmentId)
                // jj) EnrollmentRepository 타입을 Optional 로 설정했기 떄문에 throw 로 예외 처리
                .orElseThrow(() -> new IllegalArgumentException("수강 정보를 찾을 수 없습니다.enrollmentId = " + enrollmentId));

        // jj) complete 를 호출 시 enrollment entity 에서 수강 상태를 completed 로 바꾸고, 완료된 시각을 저장함
        // 수강 상태를 완료로 변환
        enrollment.complete();

        log.info("[section03] Course 서비스는 수강 완료 처리 후 이벤트만 발생한다.");

        // 수강 완료 이벤트 발행
        publisher.publishEvent(
                new Section03CourseCompletedEvent(
                        enrollment.getEnrollmentId(),
                        enrollment.getCourse().getTitle()
                )
        );

    }

}
