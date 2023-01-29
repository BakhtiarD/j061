package com.shooter;

public class Creator {
    public final int NEWBIE_EXP = 3;
    public final int ADVANCED_EXP = 10;

    public Shooter createShooter(int experience, int age, String name) {

        if (experience < NEWBIE_EXP) {
            return new Newbie(experience,age,name);
        } else if (experience < ADVANCED_EXP) {
            return new Experienced(experience,age,name);
        } else {
            return new Veteran(experience,age,name);
        }
    }
}
