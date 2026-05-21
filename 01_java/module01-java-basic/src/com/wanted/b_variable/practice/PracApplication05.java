package com.wanted.b_variable.practice;

public class PracApplication05 {

    public static void main(String[] args) {

        double korean = 80.5;
        double math = 50.6;
        double english = 70.8;

        int all = (int) (korean + math + english);
        System.out.println("총점 : " + all);
        System.out.println("평균 : " + (all/3));

    }

}
