package com.wanted.entitymapping.section02.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Price {

    @Column(name = "regular_price")
    private int regularPrice;

    @Column(name = "discount_rate")
    private double disocuntRate;

    @Column(name = "sell_price")
    private int sellPrice;

    public Price(int regularPrice, double discountRate) {
    }

    public Price() {}
}
