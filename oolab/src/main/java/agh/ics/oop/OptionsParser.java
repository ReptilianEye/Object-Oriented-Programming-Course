package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.LinkedList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> parse(String[] args) {
        List<MoveDirection> Orders = new LinkedList<>();
        for (var order : args) {
            switch (order) {
                case "f" -> {
                    Orders.add(MoveDirection.FORWARD);
                }
                case "b" -> {
                    Orders.add(MoveDirection.BACKWARD);
                }
                case "r" -> {
                    Orders.add(MoveDirection.RIGHT);
                }
                case "l" -> {
                    Orders.add(MoveDirection.LEFT);
                }
                default -> {
                    throw new IllegalArgumentException(order + " is not legal move specification");
                }
            }
        }
        return Orders;

    }
}
