package com.wanted;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class if_else {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 입력하세요 : ");

        int num = sc.nextInt();

        if (num % 2 == 0) {
            System.out.println("입력하신 숫자는 짝수입니다.");
        } else {
            System.out.println("입력하신 숫자는 홀수입니다.");
        }
        System.out.println("프로그램을 종료합니다.");
    }


}
