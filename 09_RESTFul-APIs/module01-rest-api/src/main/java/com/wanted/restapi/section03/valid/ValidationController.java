package com.wanted.restapi.section03.valid;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/valid")
public class ValidationController {

    /*
    * comment.
    *  Valid -> 검증
    *  - 유효성 검사 ex) 비밀번호는 8글자 이상, 특수문자 포함 등
    *  - 유효성 검사의 경우 프론트 단에서 조건을 만족하지 못하면
    *  - 버튼을 비활성화 or required 속성을 통해서 반드시 입력하게 만들 수 있지만,
    *  - 게발자 도구 혹은 URL 을 통한 침투를 하게 되면 유효하지 못한 값이 백엔드 서버에 넘어올 수 있다.
    *  - 따라서 백엔드에서도 @Valid 를 통해서 유효하지 않은 값을 2차적으로 방어해주어야 한다.
    * */
    
    @PostMapping("/users")
    // @NotNull 이런 식의 Valid 어노테이션을 활성화 시키기 위해서는
    // @Valid 어노테이션을 명시해야 동작한다.

    /*데이터를 객체로 변환하는 동시에 DTO 에 설정된 @NotNull, @Size 같은 조건들을 검사*/
    /*클라이언트가 보낸 JSON 형태의 HTTP 요청 본문을 자바 객체(UserDTO)로 변환*/
    /*변환된 객체 내부에 선언된 @NotNull, @Size 등의 검증 로직을 실제로 실행하라고 명령
     * 이 어노테이션이 빠지면 DTO 에 아무리 검증 규칙을 써놓아도 동작하지 않음*/
    public ResponseEntity<?> registUser(@Valid @RequestBody UserDTO user) {

        System.out.println("user = " + user);
        
        return ResponseEntity.created(URI.create("/entity/users/" + "userNo"))
                .build();
        
    }

}

/*
* 1. post 방식으로, json 데이터를 주소로 보냄
* 2. @RequestBody 를 통해 JSON 을 UserDTO 객체로 생성
* 3. @Valid 가 실행되어 UserDTO 에 설정된 모든 규칙을 하나씩 검사
* */

/*
* 1. 클라이언트의 요청: 사용자가 { "id": "user01", ... } 같은 JSON 텍스트를 본문(Body)에 담아 보냄
* 2. @RequestBody 의 가로채기: 컨트롤러의 @RequestBody 가 이 텍스트를 읽음
* 3. Jackson 의 조립: Jackson 라이브러리가 UserDTO 클래스를 보고,
*    JSON 의 "id" 값을 DTO 의 private String id 필드에 집어넣어 자바 객체를 메모리에 생성
* */
