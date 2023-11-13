package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractWorldMap {
    protected Map<Vector2d, WorldElement> animals = new HashMap<>();

    public boolean place(WorldElement animal) {
        if (canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    protected WorldElement objectAt(Vector2d position) {
        return animals.get(position);
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
