package agh.ics.oop.model;

import java.util.Collection;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {

    private final Vector2d lowerLeftBound, upperRightBound;

    public RectangularMap(int width, int height) {
        this.lowerLeftBound = new Vector2d(0, 0);
        this.upperRightBound = new Vector2d(width, height);
    }

    boolean isLegal(Vector2d newPos) {
        return newPos.follows(lowerLeftBound) && newPos.precedes(upperRightBound);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) && isLegal(position);
    }

    @Override
    public Boundary getCurrentBounds() {
        return new Boundary(lowerLeftBound,upperRightBound);
    }

    @Override
    public Collection getElements() {
        return List.of(animals);
    }
}
