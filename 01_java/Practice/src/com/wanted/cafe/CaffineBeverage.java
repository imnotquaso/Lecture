package com.wanted.cafe;

public class CaffineBeverage implements Beverage {

    @Override
    public void drink() {
        System.out.println("카페에서 음료를 마십니다.");
    }
}

// Animal = Beverage
// Mammal = Cafe
// Rabbit = Coffee, Juice
// Bunny = Latte, OrangeJuice
// RabbitFarm = Cup

// 부모 : Beverage (메서드 : drink)
// 자식 : Coffee, Juice
// 손자 : Latte(Coffee 상속), OrangeJuice(Juice 상속)