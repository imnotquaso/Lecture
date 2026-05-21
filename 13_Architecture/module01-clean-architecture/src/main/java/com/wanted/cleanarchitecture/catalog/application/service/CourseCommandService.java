package com.wanted.cleanarchitecture.catalog.application.service;

import com.wanted.cleanarchitecture.catalog.application.command.CreateCourseCommand;
import com.wanted.cleanarchitecture.catalog.application.usecase.CourseCommandUseCase;
import com.wanted.cleanarchitecture.catalog.domain.model.Course;
import com.wanted.cleanarchitecture.catalog.domain.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional // G1) command 에는 transactional 관련 클래스만 존재 , 시스템 내부의 명령, 내부에서 사용할 값// res, rep 사용자에게 보여질 값
// G1) Controller 에서 CourseCommandUseCase.handle() 실행 -> CourseCommandUseCase 를 상속받은 CourseCommandService 가 실행됨
public class CourseCommandService implements CourseCommandUseCase {

    // G1) JPA Repository 가 아닌 Domain 의 인터페이스를 받음
    private final CourseRepository repository;

    @Override
    public Long handle(CreateCourseCommand command) {

        /* 내부 코드는 UseCase 를 직접 수행하며, 이벤트 스토밍 단계에서 DomainEvent 를 (주황색) 수행한다. */

        // Course -> Entity (JPA 의존 객체, 순수 JAVA X)
        // 기존에는 엔티티 -> 순수 Java 클래스
        // service 계층은 usecase 를 조립하고, transactional 경계만을 담당한다.
        // 객체 생성은 해당 도메인 내부에서 진행하며, 메소드로만 호출한다.

        // 서비스 클래스에서 직접 new 로 Course 를 만들면 domain 계층을 침범하는 것이다.
        // G1) 서비스 계층에서 new Course() 를 직접 안함,
        //  도메인 객체 생성은 도메인 내부 메서드(팩토리 메서드)로만 진행
        Course newCourse = Course.create(command.authorId(), command.title(), command.description());
        /*
        * G1.
        *  CourseCommandService
        *  -> CourseRepository (인테페이스, Domain 소속)
        *   -> CourseRepositoryAdapter (구현체, Infrastructure 소속)
        *    -> SpringDataCourseRepository (JPA)
        *     -> DB
        * */
        Course savedCourse = repository.save(newCourse);

        return savedCourse.getId();
    }

}