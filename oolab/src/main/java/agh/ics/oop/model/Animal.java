package agh.ics.oop.model;

public class Animal implements WorldElement{
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

//    @Override
//    public String toString() {
//        return "Pozycja: " + position.toString() + ", orientacja: " + orientation.toString();
//    }


    @Override
    public String toString() {
        return orientation.toStringShort();
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public Vector2d move(MoveDirection direction, MoveValidator validator) {
        switch (direction) {
            case FORWARD -> {
                Vector2d temp = position.add(orientation.toUnitVector());
                if (validator.canMoveTo(temp))
                    position = temp;
            }
            case BACKWARD -> {
                Vector2d temp = position.subtract(orientation.toUnitVector());
                if (validator.canMoveTo(temp))
                    position = temp;
            }
            case LEFT -> orientation = orientation.previous();
            case RIGHT -> orientation = orientation.next();

        }
        return position;
    }

}
