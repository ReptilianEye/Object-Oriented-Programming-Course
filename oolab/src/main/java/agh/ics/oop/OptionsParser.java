package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] convert(String[] args) {
        MoveDirection[] Orders = new MoveDirection[args.length];
        int n = 0;
        for (var order : args) {
            switch (order) {
                case "f" -> {
                    Orders[n] = MoveDirection.FORWARD;
                    n++;
                }
                case "d" -> {
                    Orders[n] = MoveDirection.BACKWARD;
                    n++;
                }
                case "r" -> {
                    Orders[n] = MoveDirection.RIGHT;
                    n++;
                }
                case "l" -> {
                    Orders[n] = MoveDirection.LEFT;
                    n++;
                }
                default -> {
                }
            }
        }
        return Arrays.copyOfRange(Orders, 0, n);

    }
}
