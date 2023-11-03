package agh.ics.oop.model;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TextMap implements WorldMap<Integer, String> {

    private final ArrayList<AbstractMap.SimpleEntry<String, MapDirection>> map = new ArrayList<>();
    private final Map<String, Integer> positions = new HashMap<>();
    private final static int LEFT_BOUND = 0;
    private int N = 0;

    @Override
    public boolean place(String object) {
        map.add(new AbstractMap.SimpleEntry<>(object, MapDirection.EAST));
        positions.put(object, N);
        N++;
        return true;
    }

    public void swapPositions(int i, int j) {
        String val1 = map.get(i).getKey();
        MapDirection dir1 = map.get(i).getValue();
        String val2 = map.get(j).getKey();
        MapDirection dir2 = map.get(j).getValue();

        int prev1 = positions.remove(val1);
        int prev2 = positions.remove(val2);
        positions.put(val1, prev2);
        positions.put(val2, prev1);
        map.set(j, new AbstractMap.SimpleEntry<>(val1, dir1));
        map.set(i, new AbstractMap.SimpleEntry<>(val2, dir2));
    }

    private boolean toRight(MapDirection currentDirection, MoveDirection direction) {
        return (currentDirection == MapDirection.EAST && direction == MoveDirection.FORWARD) || (currentDirection == MapDirection.WEST && direction == MoveDirection.BACKWARD);

    }

    public ArrayList<AbstractMap.SimpleEntry<String, MapDirection>> getMap() {
        return map;
    }

    @Override
    public void move(String object, MoveDirection direction) {
        int i = positions.get(object);
        MapDirection currentDirection = map.get(i).getValue();
        switch (direction) {

            case LEFT -> {
                map.get(i).setValue(currentDirection.previous());
            }
            case RIGHT -> {
                map.get(i).setValue(currentDirection.next());
            }
            default -> {
                if (currentDirection != MapDirection.NORTH && currentDirection != MapDirection.SOUTH) {
                    int newPos = toRight(currentDirection, direction) ? i + 1 : i - 1;
                    if (canMoveTo(newPos))
                        swapPositions(i, newPos);
                }
            }
        }

    }

    @Override
    public boolean isOccupied(Integer position) {
        return LEFT_BOUND <= position && position < N;
    }

    @Override
    public String objectAt(Integer position) {
        return map.get(position).getKey();
    }

    @Override
    public boolean canMoveTo(Integer position) {
        return isOccupied(position);
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
