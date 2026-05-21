package com.wanted.restapi.section05.swagger;

import com.wanted.restapi.section02.responseentity.ResponseMessage;
import com.wanted.restapi.section02.responseentity.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.*;

@Tag(name = "SWAGGER 테스트 컨트롤러", description = "Section05.User 관련 REST-API")
@RestController
@RequestMapping("/swagger")
public class SwaggerController {

    private List<UserDTO> users;

    public SwaggerController() {
        this.users = new ArrayList<>();
        users.add(new UserDTO(1, "user01","pass01", "너구리", new Date()));
        users.add(new UserDTO(2, "user02","pass02", "코알라", new Date()));
        users.add(new UserDTO(3, "user03","pass03", "호랑이", new Date()));
        users.add(new UserDTO(4, "user04","pass04", "원숭이", new Date()));
    }

    @Operation(summary = "전체 사용자를 조회", description = "모든 사용자 정보를 조회하는 메서드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema(implementation = ResponseMessage.class))),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류", content = @Content(schema = @Schema(hidden = true)))
    })
    @GetMapping("/users")
    public ResponseEntity<ResponseMessage> findAllUser() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("users", users);

        ResponseMessage responseMessage = new ResponseMessage(200, "조회성공", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);

    }

    @Operation(summary = "특정 사용자 조회", description = "사용자 번호를 통해 사용자 정보를 조회함")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema(implementation = ResponseMessage.class))),
            @ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없음", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류", content = @Content(schema = @Schema(hidden = true)))
    })
    @Parameter(name = "userNo", description = "조회할 사용자 번호", required = true)
    @GetMapping("/users/{userNo}")
    public ResponseEntity<ResponseMessage> findUserByNo(@PathVariable int userNo) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        UserDTO foundUser = users
                .stream()
                .filter(user -> user.getNo() == userNo)
                .toList()
                .get(0);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("user", foundUser);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseMessage(200, "조회 성공", responseMap));
    }

    /**/
    @Operation(summary = "사용자 등록", description = "특정 사용자를 등록하는 메서드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "등록 성공", content = @Content(schema = @Schema(implementation = ResponseMessage.class))),
            @ApiResponse(responseCode = "409", description = "중복된 사용자 존재", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류", content = @Content(schema = @Schema(hidden = true)))
    })
    @PostMapping("/users")
    public ResponseEntity<?> registUser(@RequestBody UserDTO newUser) {

        System.out.println("newUser = " + newUser);

        int lastUserNo = users.get(users.size() - 1).getNo();
        int newUserNo = lastUserNo + 1;

        newUser.setNo(newUserNo);
        newUser.setEnrollAt(new Date());

        users.add(newUser);

        return ResponseEntity
                .created(URI.create("entity/users/" + newUserNo))
                .build();

    }

    /**/
    @Operation(summary = "특정 사용자 수정", description = "특정 사용자를 수정하는 메서드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "수정 성공", content = @Content(schema = @Schema(implementation = ResponseMessage.class))),
            @ApiResponse(responseCode = "404", description = "해당 사용자를 찾을 수 없음", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "409", description = "중복된 사용자 존재", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류", content = @Content(schema = @Schema(hidden = true)))
    })
    @PutMapping("/users/{userNo}")
    public ResponseEntity<?> modifyUser(@RequestBody UserDTO modifyData, @PathVariable int userNo) {

        UserDTO foundUser = users
                .stream()
                .filter(user -> user.getNo() == userNo)
                .toList()
                .get(0);

        foundUser.setId(modifyData.getId());
        foundUser.setPwd(modifyData.getPwd());
        foundUser.setName(modifyData.getName());

        return ResponseEntity
                .created(URI.create("/entity/users/" + userNo))
                .build();
    }

    /*숙제 delete 만들기*/
    @Operation(summary = "특정 사용자 삭제", description = "사용자 번호를 통해 사용자 정보를 조회함")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "삭제 성공", content = @Content(schema = @Schema(implementation = ResponseMessage.class))),
            @ApiResponse(responseCode = "404", description = "해당 사용자를 찾을 수 없음", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류", content = @Content(schema = @Schema(hidden = true)))
    })
    @Parameter(name = "userNo", description = "삭제할 사용자 번호", required = true)
    @DeleteMapping("/users/{userNo}")
    public ResponseEntity<ResponseMessage> deleteUserByNo(@PathVariable int userNo) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        UserDTO foundUser = users
                .stream()
                .filter(user -> user.getNo() == userNo)
                .findFirst()
                .orElse(null);

        if (foundUser == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ResponseMessage(404, "해당 번호의 사용자를 찾을 수 없습니다.", null));
        }

        users.remove(foundUser);

        return ResponseEntity
                .noContent()
                .build();
    }

}

/*
* comment.
*  PostMan
*  - 클라우드 서비스
*  - 배포가 된 상태
*  - FE/BE 반 모두 확인할 수 있음(workspace 에 초대)
*  - 협업 시에는 PostMan 에 우리의 API 를 정리해서 공유한다.
*  Swagger
*  - 로컬 기반 html 파일
*  - 배포를 해야지만 FE 반이 볼 수 있다.
*  - 우리끼리 API 에 대한 정보를 충분히 확인 하는 것이 Swagger 사용 목적이다.
* */