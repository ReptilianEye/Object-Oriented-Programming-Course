package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap {
    private final Map<Vector2d, Animal> animals = new HashMap<>();

    private final Vector2d lowerLeftBound, upperRightBound;

    RectangularMap(int width, int height) {
        this.lowerLeftBound = new Vector2d(0, 0);
        this.upperRightBound = new Vector2d(width, height);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    boolean isLegal(Vector2d newPos) {
        return newPos.follows(lowerLeftBound) && newPos.precedes(upperRightBound);
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d position = (Vector2d) animals.entrySet().stream().filter(entry -> animal.equals(entry.getValue())).reduce((first, rest) -> first).orElse(null);
        if (position != null && position.isLegal(lowerLeftBound, upperRightBound))
            animal.move(direction, this);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) && isLegal(position);
    }

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(lowerLeftBound, upperRightBound);
    }
}
