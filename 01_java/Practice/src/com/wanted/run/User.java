package com.wanted.run;

/* comment. User
 *  1. 폰 켜라
 *  2. 앱 실행해라
 *  3. 노래 틀어라
 *  4. 폰 꺼라
 * */

public class User {

    private SmartPhone phone;

    public User() {

        this.phone = new SmartPhone(50);

    }


    public void checkBattery() {
        System.out.println("현재 배터리: " + phone.getBattery() + "%");
    }

    public void charge() {
        System.out.println("사용자가 충전기를 연결합니다.");
        phone.charge(10);
    }

    public void powerOn() {
        phone.powerOn();
    }

    public void run() {
        phone.run();
    }

    public void play() {
        phone.play();
    }

    public void powerOff() {
        phone.powerOff();
    }

}
//    private boolean isOn;
//    private int battery;
//
//    public void charge() {
//        if (battery == 0) {
//            System.out.println("배터리가 부족합니다. 충전을 해주세요.");
//        } else {
//            System.out.println("배터리가 충분합니다. 전원을 켜주세요.");
//        }
//    }
//
//    public void powerOn() {
//        if(battery > 0 ) {
//            phone.powerOn();
//            System.out.println("핸드폰 전원을 켭니다.");
//        } else {
//            System.out.println("배터리가 부족합니다. 충전을 해주세요.");
//        }
//    }
//
//    public void run() {
//        if(isOn) {
//            phone.run();
//            System.out.println("음악 어플을 실행합니다. ");
//        } else {
//            System.out.println("배터리가 부족합니다. 음악 어플을 실행할 수 없습니다.");
//        }
//
//    }
//
//    public void play() {
//        if(isOn) {
//            phone.play();
//            System.out.println("노래를 재생합니다.");
//        } else {
//            System.out.println("배터리가 부족합니다. 노래를 재생할 수 없습니다.");
//        }
//
//    }
//
//    public void powerOff() {
//
//        phone.powerOff();
//        System.out.println("핸드폰 전원을 끕니다.");
//
//    }
//}
