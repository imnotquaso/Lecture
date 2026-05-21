package com.wanted.cafe;

// 부모 : Beverage (메서드 : drink)
// 자식 : Coffee, Juice
// 손자 : Latte(Coffee 상속), OrangeJuice(Juice 상속)

public class Cup<T extends Beverage> {
    private T beverage;

    public Cup() {}

    public Cup(T beverage) {this.beverage = beverage;}

    public T getBeverage() {return beverage;}

    public void setBeverage(T beverage) {this.beverage = beverage;}

}

