package com.shooter;

public abstract class Person implements Shooter{
    private final int experience;
    private final int age;
    private final String Name;

    public Person(int experience, int age, String name) {
        this.experience = experience;
        this.age = age;
        Name = name;
    }

    public int getExperience() {
        return experience;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return Name;
    }

    public abstract boolean makeShoot();
}
