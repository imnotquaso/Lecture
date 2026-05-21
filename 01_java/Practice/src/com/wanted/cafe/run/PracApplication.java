package com.wanted.cafe.run;

import com.wanted.cafe.*;

public class PracApplication {

    public static void main(String[] args) {

        Cup<Coffee> cup1 = new Cup<>();
        Cup<Latte> cup2 = new Cup<>();
        Cup<Juice> cup3 = new Cup<>();
        Cup<OrangeJuice> cup4 = new Cup<>();

        cup1.setBeverage(new Coffee());
        cup1.getBeverage().drink();

        cup2.setBeverage(new Latte());
        cup2.getBeverage().drink();

        cup3.setBeverage(new Juice());
        cup3.getBeverage().drink();

        cup4.setBeverage(new OrangeJuice());
        cup4.getBeverage().drink();

    }

}
