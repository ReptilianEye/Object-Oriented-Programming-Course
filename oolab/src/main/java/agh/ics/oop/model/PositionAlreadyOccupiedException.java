package agh.ics.oop.model;

public class PositionAlreadyOccupiedException extends Exception{
    PositionAlreadyOccupiedException(Vector2d position){
        super("Position " + position + " is already occupied");
    }
}
