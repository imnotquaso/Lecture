package com.wanted.practice.controller;

import org.w3c.dom.ls.LSOutput;

public class ConditionPractice04 {

    public void season(int month) {

        String season;
        if (month == 1 || month == 2 || month == 12) {
            season = "겨울";
        } else if (month >= 3 && month <= 5) {
            season = "봄";
        } else if (month >= 6 && month <= 8) {
            season = "여름";
        } else if (month >= 9 && month <= 11) {
            season = "가을";
        } else {
            season = "잘못 입력된 달";
        }

        int month = 12;

        switch (month) {
            case 1, 2, 12 :
                System.out.println(month + " 월은 " + season + "입니다");
            case 3, 4, 5 :
                System.out.println(month + " 월은 " + season + "입니다");
                break;
            case 6, 7, 8 :
                System.out.println(month + " 월은 " + season + "입니다");
                break;
            case 9, 10, 11 :
                System.out.println(month + " 월은 " + season + "입니다");
                break;
            default :
                System.out.println(month + " 월은 잘못 입력된 달입니다.");
        }
    }

}
