package com.wanted.b_variable.practice;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class PracApplication03 {

    public static void main(String[] args) {

        String age;
        String sex;
        String name;
        String height;


        Scanner sc = new Scanner(System.in);
        System.out.println("나이를 입력하세요 : ");
        age = sc.next();
        System.out.println("성별을 입력하세요: ");
        sex = sc.next();
        System.out.println("키를 입력하세요: ");
        name = sc.next();
        System.out.println("이름을 입력하세요");
        height = sc.next();

        System.out.println(age + "살 " + sex + name +"님 키가 " + height + "이시군요!");
    }


}
