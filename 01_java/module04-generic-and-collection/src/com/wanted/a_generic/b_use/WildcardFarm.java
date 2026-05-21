package com.wanted.a_generic.b_use;

public class WildcardFarm {

    public void anyType(RabbitFarm<?> farm) {
        farm.getAnimal().cry();
    }

    // extends : Bunny, DrunkenBunny
    public void extendsType(RabbitFarm<? extends Bunny> farm) {
        farm.getAnimal().cry();
    }

    // super : Bunny, Rabbit 만 가능
    public void superType(RabbitFarm<? super Bunny> farm) {
        farm.getAnimal().cry();
    }



}
