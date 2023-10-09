package agh.ics.oop;


import agh.ics.oop.model.MoveDirection;

import java.util.Arrays;

public class World {
    public static void main(String[] args) {
        System.out.println("System wystartował");
        run(OptionsParser.Convert(args));
        System.out.println("System zakończył działanie");
    }

    static void run(MoveDirection[] args) {
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

//System.out.println("Zwierzak idzie do przodu");
//        String orders = Arrays.toString(args);
//        System.out.println(orders.substring(1, orders.length() - 1));

//        for (var order : args) {
//            switch (order) {
//                case  "f":
//                    System.out.println("Zwierzak idzie do przodu");
//                    break;
//                case "d":
//                    System.out.println("Zwierzak idzie do tyłu");
//                    break;
//                case "r":
//                    System.out.println("Zwierzak skręca w prawo");
//                    break;
//                case "l":
//                    System.out.println("Zwierzak skręca w lewo");
//                    break;
//                default: {
//                    break;
//                }
//            }
//        }
    }
}
