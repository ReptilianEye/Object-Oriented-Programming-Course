package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractWorldMap {
    Map<Vector2d, WorldElement> animals = new HashMap<>();

    protected WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }
    public boolean place(WorldElement animal) {
        if (canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    protected boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }

    public void move(Animal animal, MoveDirection direction, MoveValidator validator) {
        Vector2d prevPos = animal.getPosition();
        if (!prevPos.equals(animal.move(direction, validator))) {
            animals.remove(prevPos);
            place(animal);
        }
    }
}
