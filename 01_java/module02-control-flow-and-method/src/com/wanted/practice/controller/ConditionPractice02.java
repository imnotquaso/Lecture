package com.wanted.practice.controller;

public class ConditionPractice02 {
    public void checkNumber(int num) {

        if (num > 0) {
            if (num % 2 == 0) {
                System.out.println("짝수다");
            } else {
                System.out.println("홀수다");
            }
        } else {
            System.out.println("양수만 입력해주세요.");
        }
    }
}

