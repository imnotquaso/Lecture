package com.wanted.run;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        /*
        * comment.
        *  1. 사용자는 스마트폰의 전원을 켠다. 배터리가 0%라면 켜지지 않는다.
        *  2. 음악 앱을 실행한다. 전원이 꺼져 있다면 앱을 실행할 수 없다.
        *  3. 음악을 재생하면 10초당 배터리가 1%씩 감소한다.
        *  4. 배터리가 5% 미만이 되면 "배터리가 부족합니다"라는 경고 메시지를 띄운다.
        *  5. 충전기를 연결하면 배터리가 서서히 충전된다. 충전 중에는 배터리 소모가 중단된다..
        * */

        /* comment. User
          *  1. 폰 켜라
          *  2. 앱 실행해라
          *  3. 노래 틀어라
          *  4. 폰 꺼라
          * */
         /* comment. SmartPhone
           *  1. 전원 켜기
           *  2. 음악 앱 실행하기
           *  3. 음악 재생하기
           *  4. 전원 끄기
           * */
        /*  comment. MusicApp
          *  1. 앱 켜기
          *  2. 노래 재생하기
          *  3. 노래 멈추기
          *  4. 앱 끄기
          * */


        User user = new User();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("0. 배터리 상태 확인");
            System.out.println("1. 스마트폰 전원 켬");
            System.out.println("2. 음악 어플을 실행");
            System.out.println("3. 음악을 재생");
            System.out.println("4. 스마트폰 전원 끔");
            System.out.println("5. 스마트폰 충전");
            System.out.println("9. 프로그램을 종료");
            System.out.println("당신의 선택은? : ");

            int no = sc.nextInt();

            switch (no) {
                case 0 : user.checkBattery(); break;
                case 1 : user.powerOn(); break;
                case 2 : user.run(); break;
                case 3 : user.play(); break;
                case 4 : user.powerOff(); break;
                case 5 : user.charge(); break;
                case 9 :
                    System.out.println("프로그램을 종료합니다.");break;
                default :
                    System.out.println("잘못된 번호를 작성했습니다.");
            }

            if (no == 9) {
                break;
            }

        }

    }

}
