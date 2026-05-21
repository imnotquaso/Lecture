package com.wanted.practice.run;

import com.wanted.practice.controller.ConditionPractice02;
import com.wanted.practice.controller.ConditionPractice03;

import java.util.Scanner;

public class Application03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("국어점수 : ");
        int korean = sc.nextInt();
        System.out.print("수학점수 : ");
        int math = sc.nextInt();
        System.out.print("영어점수 : ");
        int english = sc.nextInt();

        double sum = 0.0;
        double avg = 0.0;

        sum = (korean + math + english);
        avg = (sum / 3);

        ConditionPractice03 conprac03 = new ConditionPractice03();

        conprac03.exam(korean, math, english);
    }

}
