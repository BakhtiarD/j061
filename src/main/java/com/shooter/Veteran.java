package com.shooter;

public class Veteran  extends Person {

    public Veteran(int experience, int age, String name) {
        super(experience, age, name);
    }

    @Override
    public boolean makeShoot() {
        double prob = (0.9d - this.getAge() * 0.01d);
        double rand = Math.random();
        return (prob >= rand);
    }
}
