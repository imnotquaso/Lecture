package com.wanted.run;


/*
 * comment.
 *  1. 사용자는 스마트폰의 전원을 켠다. 배터리가 0%라면 켜지지 않는다.
 *  2. 음악 앱을 실행한다. 전원이 꺼져 있다면 앱을 실행할 수 없다.
 *  3. 음악을 재생하면 10초당 배터리가 1%씩 감소한다.
 *  4. 배터리가 5% 미만이 되면 "배터리가 부족합니다"라는 경고 메시지를 띄운다.
 *  5. 충전기를 연결하면 배터리가 서서히 충전된다. 충전 중에는 배터리 소모가 중단된다..
 * */
 /*  comment. MusicApp
   *  1. 앱 켜기
   *  2. 노래 재생하기
   *  3. 노래 멈추기
   *  4. 앱 끄기
   * */

public class MusicApp {

//    private boolean isOn;
//    private int battery;


    public void turnOn(int battery) {

        if(battery>0) {
            System.out.println("음악 어플을 실행합니다.");
        } else {
            System.out.println("배터리가 부족합니다. 충전해주세요.");
        }

    }

//    public void start() {
//
//        if(isOn) {
//            if (this.battery > 5) {
//                System.out.println("노래를 재생합니다.");
//                this.battery -= 10;
//                System.out.println("현재 휴대폰의 배터리는 " + this.battery + "(%) 입니다.");
//            } else {
//                System.out.println("배터리가 부족합니다. 노래를 재생할 수 없습니다. ");
//            }
//        } else {
//            System.out.println("전원이 꺼져있습니다. 음악 어플을 시행할 수 없습니다.");
//        }
//
//    }

    public void stop() {

        System.out.println("노래를 정지합니다.");

    }


    public void turnOff() {

        System.out.println("음악 어플을 종료합니다.");

    }

}
