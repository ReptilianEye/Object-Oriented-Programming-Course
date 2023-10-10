package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] convert(String[] args) {
        MoveDirection[] Orders = {};
        for (var order : args) {
            switch (order) {
                case "f" -> {
                    Orders = Arrays.copyOf(Orders, Orders.length + 1);
                    Orders[Orders.length - 1] = MoveDirection.FORWARD;
                }
                case "d" -> {
                    Orders = Arrays.copyOf(Orders, Orders.length + 1);
                    Orders[Orders.length - 1] = MoveDirection.BACKWARD;
                }
                case "r" -> {
                    Orders = Arrays.copyOf(Orders, Orders.length + 1);
                    Orders[Orders.length - 1] = MoveDirection.RIGHT;
                }
                case "l" -> {
                    Orders = Arrays.copyOf(Orders, Orders.length + 1);
                    Orders[Orders.length - 1] = MoveDirection.LEFT;
                }
                default -> {}
            }
        }
        return Orders;

    }
}
