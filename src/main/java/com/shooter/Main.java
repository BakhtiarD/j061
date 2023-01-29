package com.shooter;
/*
Описать несколько классов: абстрактный класс-родитель с полями и методами, характерными для всех объектов задания,
при этом некоторый метод или методы может быть чисто виртуальным и несколько классов-наследников, определяющих
дополнительные поля (при необходимости) и переопределяющие некоторый виртуальный метод (методы).
В главной программе должен быть объявлен массив (статический или динамический) объектов (родительского класса),
в который помещаются классов потомков. В главной консольной программе создаются соответствующие объекты и
выполняются действия, указанные в задании. Программно промоделировать стрельбу по мишени группой человек.
Каждый человек имеет свое имя, возраст (в годах) и стаж обучения стрельбе (в годах).
Люди делятся на новичков, опытных и ветеранов (потомки класса человек).
Для каждого человека определите полиморфный метод. «Стрелять» без параметров,
возвращающих логическое значение (попал – true, не попал – false).
Попадание определяется случайным образом, причем для новичка вероятность попасть равна 0,01*стаж обучения;
для опытного = 0,05*стаж обучения стрельбе; для ветерана = 0,9– 0,01*возраст.
Люди стреляют по очереди, начиная с первого пока кто-то не попадет в мишень.
Стрельба прекращается после того, как кто-то попал или все выстрелили по одному разу.
После каждого выстрела нужно выводить на экран всю информацию о стреляющем и результат стрельбы.
В главной программе создайте массив из 7 людей в таком порядке: новичок, опытный, ветеран, опытный,
новичок и произведите стрельбу с выводом ее результатов.

Использование дизайн-паттернов будет являтся плюсом.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Main {
    public static ArrayList<Shooter> readFile(String fileName) {
        ArrayList<Shooter> resultArray = new ArrayList<>();
        var factory = new Creator();
        Path path = Paths.get("./src/main/resources/" + fileName);

        try (Stream<String> stream = Files.lines(path)) {
            String[] lines = stream.toArray(String[]::new);
            for (String line : lines) {
                String[] columns = line.split(",");
                try {
                    resultArray.add(factory.createShooter(Integer.parseInt(columns[0]), Integer.parseInt(columns[1]), columns[2]));
                } catch (NumberFormatException ex) {
                    System.out.println("invalid file format");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultArray;
    }

    public static void main(String[] args) {

        ArrayList<Shooter> shooters = readFile("shooters.csv");
        StringBuilder sb = new StringBuilder();
        for (Shooter shooter : shooters) {
            boolean shoot = shooter.makeShoot();
            sb.append(shooter.getName()).append(": ");
            if (!shoot) sb.append("did not ");
            sb.append("hit the target").append("\n");
            if (shoot) break;
        }
        System.out.println(sb);
    }
}
