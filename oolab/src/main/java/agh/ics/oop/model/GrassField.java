package agh.ics.oop.model;

import java.util.*;

public class GrassField extends AbstractWorldMap{

    private final Map<Vector2d, WorldElement> grasses;

    public GrassField(int n) {
        grasses = generateGrass(n);
    }

    private Map<Vector2d, WorldElement> generateGrass(int n) {
        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(n);
        Iterator<Vector2d> it = randomPositionGenerator.iterator();
        Map<Vector2d, WorldElement> placed_grasses = new HashMap<>();
        while (it.hasNext()) {
            Vector2d next = it.next();
            placed_grasses.put(next, new Grass(next));
        }
        return placed_grasses;
    }

    public boolean isOccupied(Vector2d position) {
        WorldElement object = objectAt(position);
        return object instanceof Animal;
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        WorldElement animal = super.objectAt(position);
        return animal != null ? animal : grasses.get(position);
    }

    public Collection getElements() {
        return List.of(animals, grasses);
    }

    private Vector2d lowerLeftBound() {
        Vector2d leftBound = grasses.keySet().stream().reduce(new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE), Vector2d::lowerLeft);
        leftBound = animals.keySet().stream().reduce(leftBound, Vector2d::lowerLeft);
        return leftBound;
    }

    private Vector2d upperRightBound() {
        Vector2d rightBound = grasses.keySet().stream().reduce(new Vector2d(0, 0), Vector2d::upperRight);
        rightBound = animals.keySet().stream().reduce(rightBound, Vector2d::upperRight);
        return rightBound;
    }
    @Override
    protected Boundary getCurrentBounds() {
        return new Boundary(lowerLeftBound(),upperRightBound());
    }

}
