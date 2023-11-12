package agh.ics.oop.model;

import java.util.Collection;
import java.util.List;

public class RectangularMap extends AbstractWorldMap implements WorldMap<Vector2d, WorldElement> {

    private final Vector2d lowerLeftBound, upperRightBound;

    public RectangularMap(int width, int height) {
        this.lowerLeftBound = new Vector2d(0, 0);
        this.upperRightBound = new Vector2d(width, height);
    }

    boolean isLegal(Vector2d newPos) {
        return newPos.follows(lowerLeftBound) && newPos.precedes(upperRightBound);
    }

    @Override
    public void move(WorldElement object, MoveDirection direction) {
        Animal animal = (Animal) object;
        super.move(animal, direction, this);
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return (Animal) super.objectAt(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) && isLegal(position);
    }

    @Override
    public Collection getElements() {
        return List.of(animals);
    }

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(lowerLeftBound, upperRightBound);
    }
}
