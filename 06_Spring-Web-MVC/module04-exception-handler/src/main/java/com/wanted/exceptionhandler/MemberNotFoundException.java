package com.wanted.exceptionhandler;

public class MemberNotFoundException extends Exception{

    public MemberNotFoundException(String message) {

        // super = 부모한테 전달받은 메세지를 전송
        super(message);

    }

}
