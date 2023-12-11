package agh.ics.oop.model;

import java.util.*;

import static java.lang.Thread.sleep;

abstract class AbstractWorldMap implements WorldMap<Vector2d, WorldElement> {
    protected Map<Vector2d, WorldElement> animals = new HashMap<>();
    List<MapChangeListener> subscribers = new LinkedList<>();

    private static int globalId = 0;
    private final int id;

    {
        id = globalId;
        globalId++;
    }

    public int getId() {
        return id;
    }

    public void addSubscriber(MapChangeListener subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(MapChangeListener subscriber) {
        subscribers.remove(subscriber);
    }

    private void mapChanged(String message) {
        for (var sub : subscribers) {
            sub.mapChanged(this, message);
        }
    }

    public void place(WorldElement animal) throws PositionAlreadyOccupiedException {
        Vector2d newPosition = animal.getPosition();
        if (!canMoveTo(newPosition)) {
            throw new PositionAlreadyOccupiedException(newPosition);
        }
        animals.put(newPosition, animal);
        mapChanged("Animal placed on " + newPosition);
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

    public abstract Boundary getCurrentBounds();

    public void move(WorldElement element, MoveDirection direction) {
        Animal animal = (Animal) element;
        Vector2d prevPos = animal.getPosition();
        MapDirection prevOrientation = animal.getOrientation();
        Vector2d newPos = animal.move(direction, this);
        MapDirection newOrientation = animal.getOrientation();
        if (!prevPos.equals(newPos)) {
            animals.remove(prevPos);
            try {
                place(animal);
            } catch (
                    PositionAlreadyOccupiedException ignored) {
                return;
            }

        }
        if (!prevPos.equals(newPos)) {
            mapChanged("Animal from " + prevPos + " moved to " + newPos);
        } else if (!prevOrientation.equals(newOrientation)) {
            mapChanged("Animal rotated from " + prevOrientation + " to " + newOrientation);
        }
        try {
            sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        Boundary boundary = this.getCurrentBounds();
        return new MapVisualizer(this).draw(boundary.leftCorner(), boundary.rightCorner());
    }
}
