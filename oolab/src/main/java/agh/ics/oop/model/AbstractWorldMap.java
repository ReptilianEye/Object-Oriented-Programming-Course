package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractWorldMap implements WorldMap<Vector2d, WorldElement> {
    protected Map<Vector2d, WorldElement> animals = new HashMap<>();

    public boolean place(WorldElement animal) {
        if (canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }

    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }

    public void move(WorldElement element, MoveDirection direction) {
        Animal animal = (Animal) element;
        Vector2d prevPos = animal.getPosition();
        if (!prevPos.equals(animal.move(direction, this))) {
            animals.remove(prevPos);
            place(animal);
        }
    }
}
