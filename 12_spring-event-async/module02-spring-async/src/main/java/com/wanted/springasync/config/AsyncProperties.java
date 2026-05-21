package com.wanted.springasync.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

// jj) yml 의 app 의 async 을 하나의 객체로셔 변수로 담아놓음
@ConfigurationProperties(prefix = "app.async")
public record AsyncProperties(

        /*
        * comment.
        *  yml 에 작성한 async 관련 값을 변수처리하여 활용하기 위함
        *  케밥케이스 단어 - 단어 / 카멜 케이스 단어딴어
        * */

        int corePoolSize,
        int maxPoolSize,
        int queueCapacity,
        String threadNamePreFix
) {

}
