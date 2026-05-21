package com.wanted.practice.run;

import com.wanted.c_method.Calculator;
import com.wanted.practice.controller.ConditionPractice02;

import java.util.Scanner;

public class Application02 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("숫자를 한 개 입력하세요 : ");
        int num = sc.nextInt();

        ConditionPractice02 conprac02 = new ConditionPractice02();

        conprac02.checkNumber(num);
    }

}
