package agh.ics.oop.model;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;

    public Animal() {
        orientation = MapDirection.NORTH;
        position = new Vector2d(2, 2);
    }

    public Animal(Vector2d position) {
        this();
        this.position = position;
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Pozycja: " + position.toString() + ", orientacja: " + orientation.toString();
    }

    public boolean isAt(Vector2d position) {
        return position != null && position.equals(position);
    }

    private boolean isLegal(Vector2d newPos) {
        Vector2d lowerBound = new Vector2d(0, 0);
        Vector2d upperBound = new Vector2d(4, 4);
        return newPos.follows(lowerBound) && newPos.precedes(upperBound);
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case FORWARD -> {
                Vector2d temp = position.add(orientation.toUnitVector());
                if (isLegal(temp))
                    position = temp;
            }
            case BACKWARD -> {
                Vector2d temp = position.subtract(orientation.toUnitVector());
                if (isLegal(temp))
                    position = temp;
            }
            case LEFT -> orientation = orientation.previous();
            case RIGHT -> orientation = orientation.next();

        }
    }

}
