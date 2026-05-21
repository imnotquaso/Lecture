package com.wanted.springevent.section03.listener;

import com.wanted.springevent.section03.event.Section03CourseCompletedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
//@Order(1)
public class Section03CourseCompletionAuditEventListener {

    /*
    * comment.
    *  해당 클래스는 1개의 이벤트가 발생했을 때
    *  여러 개의 Listener 가 동작하는 것을 보여주기 위함이다.
    *  해당 클래스는 이벤트가 발생하면 Audit(감사, 로깅) 처리를 하는 Listener 역할을 한다.
    * */

    private static final Logger log = LoggerFactory.getLogger(Section03CourseCompletionAuditEventListener.class);

    // jj) log 는 대부분 aop 사용
//    @EventListener
//    public void eventHandler(Section03CourseCompletedEvent event) {
//
//        log.info(
//                "[section03] 감사 로그 기록 "
//        );
//
//    }


}
