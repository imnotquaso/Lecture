package com.wanted;

import java.util.Scanner;

public class if2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("숫자를 입력해주세요 : ");
        int num = sc.nextInt();

        if (num > 0 && num % 2 == 0){
            System.out.println("입력하신 숫자는 양수이면서 짝수입니다.");
        }
        System.out.println("프로그램을 종료합니다.");
    }
}
