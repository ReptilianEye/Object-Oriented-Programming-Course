package agh.ics.oop.model;

public class Animal {
    MapDirection orientation;
    Vector2d position;

    public Animal() {
        orientation = MapDirection.NORTH;
        position = new Vector2d(2, 2);
    }

    public Animal(Vector2d position) {
        this();
        this.position = position;
    }

    @Override
    public String toString() {
        return "Pozycja: " + position.toString() + ", orientacja: " + orientation.toString();
    }

    public boolean isAt(Vector2d position) {
        return this.position != null && this.position.equals(position);
    }

    private boolean isLegal(Vector2d newPos) {
        Vector2d lowerBound = new Vector2d(0, 0);
        Vector2d upperBound = new Vector2d(4, 4);
        return newPos.follows(lowerBound) && newPos.precedes(upperBound);
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case FORWARD -> {
                Vector2d temp = this.position.add(this.orientation.toUnitVector());
                if (isLegal(temp))
                    position = temp;
            }
            case BACKWARD -> {
                Vector2d temp = this.position.subtract(this.orientation.toUnitVector());
                if (isLegal(temp))
                    position = temp;
            }
            case LEFT -> {
                orientation = this.orientation.previous();
            }
            case RIGHT -> {
                orientation = this.orientation.next();
            }
        }
    }

}
