package com.shooter;

public class Experienced  extends Person {


    public Experienced(int experience, int age, String name) {
        super(experience, age, name);
    }

    @Override
    public boolean makeShoot() {
        double prob = this.getExperience() * 0.05d;
        double rand = Math.random();
        return (prob >= rand);
    }
}
