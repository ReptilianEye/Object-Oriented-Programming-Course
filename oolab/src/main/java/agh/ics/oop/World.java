package agh.ics.oop;


import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

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
