package com.wanted.run;

/*  comment. MusicApp
  *  1. 앱 켜기
  *  2. 노래 재생하기
  *  3. 노래 멈추기
  *  4. 앱 끄기
  * */

/* comment. SmartPhone
 *  1. 전원 켜기
 *  2. 음악 앱 실행하기
 *  3. 음악 재생하기
 *  4. 전원 끄기
 * */

public class SmartPhone {

    private MusicApp musicapp = new MusicApp();

    private boolean isOn;
    private int battery;

    public SmartPhone(int i) {

        this.battery = i;
    }

//    public SmartPhone(int battery) {
//        this.battery = (battery > 100) ? 100 : battery;
//    }

    public void charge(int amount) {
        this.battery += amount;
        if(this.battery > 100) this.battery = 100;
        System.out.println("⚡ 충전 중... 현재 배터리: " + this.battery + "%");
    }

    public int getBattery() {
        return this.battery;
    }

    public void powerOn() {
        // 문제 상황 : 배터리 상태가 공유가 안 되고 있다.
        System.out.println(" 배터리 " + battery);
        if (this.battery > 0){
            musicapp.turnOn(battery);
            System.out.println("스마트폰 전원을 켭니다.");
        } else {
            System.out.println("배터리가 부족합니다. 충전해주세요.");
            }
    }

    public void run() {
        if(this.battery>0) {
//            musicapp.start();
            System.out.println("음악 어플을 실행합니다.");
        } else {
            System.out.println("배터리가 부족합니다. 음악 어플을 실행할 수 없습니다.");
        }



    }

    public void play() {

        musicapp.stop();

    }

    public void powerOff() {

        musicapp.turnOff();

    }
}
