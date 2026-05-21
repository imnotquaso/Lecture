package com.wanted.membership.professor.view;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class ProfessorInputView {

    private final Scanner sc = new Scanner(System.in);

    public void displayMainMenu() {
        while (true) {
            System.out.println();
            System.out.println("=================================");
            System.out.println("         LMS 실습 메인 메뉴         ");
            System.out.println("=================================");
            System.out.println("1. 로그인");
            System.out.println("2. 학생 회원가입");
            System.out.println("3. 교수 회원가입");
            System.out.println("4. 프로그램 종료");
            System.out.print("번호를 입력해주세요 : ");

            int menu = inputInt();

            switch (menu) {
                case 1:
                    login();
                    break;
                case 2:
                    studentMember();
                    break;
                case 3:
                    professorMember();
                    break;
                case 4:
                    outputView.printMessage("== 프로그램을 종료합니다. ==");
                    return;
                default:
                    outputView.printError("다시 선택해주세요.");
            }
        }
    }


    private void login() {
        outputView.printMessage("\n--- 로그인을 위한 아이디와 비밀번호룰 입혁해주세요. ---");
        System.out.println("아이디 : " + id);
        System.out.println("비밀번호 : " + pwd);
    }
// 교수번호, 비밀번호, 주소, 휴대폰번호, 이메일, 교수키번호
    private void professorMember() {
        while (true) {
            System.out.println();
            System.out.println("=================================");
            System.out.println("      교수용 회원가입을 시작합니다.      ");
            System.out.println("=================================");
            System.out.println("아이디를 입력해주세요.");
            String id = sc.nextLine();
            System.out.println("비밀번호를 입력해주세요.");
            String pwd = sc.nextLine();
            System.out.println("주소를 입력해주세요.");
            String address = sc.nextLine();
            System.out.println("휴대폰 번호를 입력해주세요.");
            String phone = sc.nextLine();
            System.out.println("이메일을 입력해주세요.");
            String email = sc.nextLine();
            System.out.println("교수용 식변번호를 입력해주세요.");
            String code = sc.nextLine();

            int menu = inputInt();

        }
    }

}