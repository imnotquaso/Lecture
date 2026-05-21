package com.wanted.practice.controller;

public class ConditionPractice03 {

    public void exam (int korean, int math, int english) {

        double sum = 0.0;
        double avg = 0.0;


        sum = (korean + math + english);
        avg = (sum / 3);

        if (korean >= 40 && math >= 40 && english >= 40) {
            if (avg >= 60) {
                System.out.println("축하합니다, 합격입니다");
            } else {
                System.out.println("불합격입니다.");
            }
        }else{
            System.out.println("불합격입니다.");
        }
        }

    }

