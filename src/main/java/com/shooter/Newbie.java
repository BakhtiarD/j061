package com.shooter;

public class Newbie extends Person {

    public Newbie(int experience, int age, String name) {
        super(experience, age, name);
    }

    @Override
    public boolean makeShoot() {
        double prob = this.getExperience() * 0.01d;
        double rand = Math.random();
        return (prob >= rand );
    }
}
