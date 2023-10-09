package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;

public class OptionsParser {
    public static MoveDirection[] Convert(String[] args) {
        ArrayList<MoveDirection> orders = new ArrayList<>();
        for (var order : args) {
            switch (order) {
                case "f":
                    orders.add(MoveDirection.FORWARD);
                    break;
                case "d":
                    orders.add(MoveDirection.BACKWARD);
                    break;
                case "r":
                    orders.add(MoveDirection.RIGHT);
                    break;
                case "l":
                    orders.add(MoveDirection.LEFT);
                    break;
                default:
                    break;

            }
        }
        MoveDirection[] result = {};
        if (!orders.isEmpty())
            result = orders.toArray(new MoveDirection[0]);
        return result;
    }
}
