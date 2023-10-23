package agh.ics.oop;


import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.List;
import java.util.Map;

public class World {
    public static void main(String[] args) {
        System.out.println("System wystartował");
        run(OptionsParser.parse(args));
        System.out.println("System zakończył działanie");
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        MapDirection direction1 = MapDirection.WEST;
        System.out.println(direction1);
        direction1 = direction1.next();
        System.out.println(direction1);
        direction1 = direction1.previous();
        System.out.println(direction1);
        System.out.println(direction1.toUnitVector());

        Animal zwierz = new Animal();
        System.out.println(zwierz);
        zwierz = new Animal(new Vector2d(5,23));
        System.out.println(zwierz);

    }

     static void run(List<MoveDirection> args) {
        for (var order : args) {
            switch (order) {
                case FORWARD -> {
                    System.out.println("Zwierzak idzie do przodu");
                }
                case BACKWARD -> {
                    System.out.println("Zwierzak idzie do tyłu");
                }
                case LEFT -> {
                    System.out.println("Zwierzak skręca w lewo");
                }
                case RIGHT -> {
                    System.out.println("Zwierzak skręca w prawo");
                }
            }
        }
    }
}
