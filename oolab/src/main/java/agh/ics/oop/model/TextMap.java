package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TextMap implements WorldMap<Integer, String> {


    private final ArrayList<TextMapElement> map = new ArrayList<>();
    //    private final ArrayList<AbstractMap.SimpleEntry<String, MapDirection>> map = new ArrayList<>();
    private final Map<String, Integer> positions = new HashMap<>();
    private final static int LEFT_BOUND = 0;
    private int N = 0;

    @Override
    public void place(String text) {
        map.add(new TextMapElement(text, MapDirection.EAST));
        positions.put(text, N);
        N++;
    }

    public void swapPositions(int i, int j) {
        var a = map.get(i);
        var b = map.get(j);

        // update hashmap
        positions.put(b.text(), i);
        positions.put(a.text(), j);
        // update map
        map.set(i, b);
        map.set(j, a);
    }

    private boolean toRight(MapDirection currentDirection, MoveDirection direction) {
        return (currentDirection == MapDirection.EAST && direction == MoveDirection.FORWARD) || (currentDirection == MapDirection.WEST && direction == MoveDirection.BACKWARD);

    }

    public ArrayList<TextMapElement> getMap() {
        return map;
    }

    @Override
    public void move(String text, MoveDirection direction) {
        int i = positions.get(text);
        MapDirection currentDirection = map.get(i).direction();
        switch (direction) {

            case LEFT -> {
                map.set(i, new TextMapElement(text, currentDirection.previous()));
            }
            case RIGHT -> {
                map.set(i, new TextMapElement(text, currentDirection.next()));
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
        return map.get(position).text();
    }

    @Override
    public boolean canMoveTo(Integer position) {
        return isOccupied(position);
    }

    @Override
    public Collection getElements() {
        return map;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("||| ");
        for (var el : map) {
            out.append("(").append(el.direction().toStringArrows()).append(" ").append(el.text()).append(") ");
        }
        out.delete(out.length()-1,out.length());
        out.append(" |||");
        return out.toString();
    }
}
