package com.wanted.c_operators.practice;

import java.util.Scanner;

public class PracApplication06 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int korean;
        int math;
        int english;

        System.out.println("국어 점수를 입력하세요 : ");
        korean = sc.nextInt();

        System.out.println("수학 점수를 입력하세요 : ");
        math = sc.nextInt();

        System.out.println("영어 점수를 입력하세요 : ");
        english = sc.nextInt();

        int total = (korean + math + english);
        double average = (total / 3);

        System.out.println("합계 : " + total);
        System.out.println("평균 : " + average);

        if (korean >= 40 && math >= 40 && english >= 40 && average >= 60 ){
            System.out.println("합격");
        } else {
            System.out.println("불합격");
        }



    }

}
