package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractWorldMap implements WorldMap<Vector2d, WorldElement> {
    protected Map<Vector2d, WorldElement> animals = new HashMap<>();

    public void place(WorldElement animal) throws PositionAlreadyOccupiedException {
        Vector2d newPosition = animal.getPosition();
        if (!canMoveTo(newPosition)) {
            throw new PositionAlreadyOccupiedException(newPosition);
        }
        animals.put(newPosition, animal);
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
    protected abstract Boundary getCurrentBounds();

    public void move(WorldElement element, MoveDirection direction) {
        Animal animal = (Animal) element;
        Vector2d prevPos = animal.getPosition();
        if (!prevPos.equals(animal.move(direction, this))) {
            animals.remove(prevPos);
            try {
                place(animal);
            } catch (
                    PositionAlreadyOccupiedException ignored) {
            }
        }
    }

    @Override
    public String toString() {
        Boundary boundary = this.getCurrentBounds();
        return new MapVisualizer(this).draw(boundary.leftCorner(), boundary.rightCorner());
    }
}
