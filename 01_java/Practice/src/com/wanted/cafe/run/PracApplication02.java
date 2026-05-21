package com.wanted.cafe.run;

import com.wanted.cafe.Cup;
import com.wanted.cafe.Latte;
import com.wanted.cafe.Cafe;

public class PracApplication02 {

    public static void main(String[] args) {

        Cafe cafe = new Cafe();

        cafe.anyType(new Cup<Latte>(new Latte()));

    }

}
