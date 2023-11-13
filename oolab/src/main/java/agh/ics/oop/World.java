package agh.ics.oop;


import agh.ics.oop.model.*;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class World {

    public static void main(String[] args) {
        System.out.println("System wystartował");

        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));
        WorldMap map = new GrassField(10);
        Simulation simulation = new Simulation(directions, positions, map);
        simulation.run();
        System.out.println(map);
        System.out.println("System zakończył działanie");


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
