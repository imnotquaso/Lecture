package com.wanted;

import java.util.Scanner;

public class If {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("숫자 한개를 입력하세요");
        int num = sc.nextInt();

        if (num % 2 == 0 ) {
            System.out.println("입력하신 숫자는 짝수입니다.");
        }

        System.out.println("프로그램을 종료합니다.");
    }

}
