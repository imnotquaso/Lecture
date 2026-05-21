package com.wanted.c_operators.practice;

import org.w3c.dom.ls.LSOutput;

public class PracApplication07 {
    public static void main(String[] args) {
        int numOfApples = 92;
        int maxOfBasket = 10;
        int numOfBasket;

        double i = numOfApples / maxOfBasket;
        double numOfBasket = (int) Math.ceil(i);

        numOfBasket = (int) Math.ceil((double) (numOfApples / maxOfBasket));

        System.out.println("필요한 바구니의 개수는 " + numOfBasket + "이다");
    }

}
