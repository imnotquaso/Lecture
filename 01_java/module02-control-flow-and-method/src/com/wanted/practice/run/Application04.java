package com.wanted.practice.run;

import com.wanted.practice.controller.ConditionPractice03;

import java.util.Scanner;

public class Application04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("1~12 사이의 정수 입력 : ");

        int month = sc.nextInt();

        ConditionPractice04 conprac04 = new ConditionPractice04();

        conprac04.season(month);
    }

}
