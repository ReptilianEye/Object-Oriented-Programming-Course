package agh.ics.oop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class AnimalTest {


    @Test
    void move() {
        //given
        //moves test
        MoveValidator validator = new RectangularMap(4, 4);
        Animal tested1 = new Animal();
        MapDirection expectedO1 = MapDirection.NORTH;
        Vector2d expectedP1 = new Vector2d(2, 2);

        MapDirection expectedO2 = MapDirection.NORTH;
        Vector2d expectedP2 = new Vector2d(2, 3);

        MapDirection expectedO3 = MapDirection.NORTH;
        Vector2d expectedP3 = new Vector2d(2, 2);

        MapDirection expectedO4 = MapDirection.WEST;
        Vector2d expectedP4 = new Vector2d(2, 2);

        Vector2d expectedP5 = new Vector2d(1, 2);


        MapDirection expectedO6 = MapDirection.EAST;
        Vector2d expectedP6 = new Vector2d(1, 2);

        MapDirection expectedO7 = MapDirection.SOUTH;

        //bottom right test
        Animal testedBR = new Animal(new Vector2d(4, 4));
        List<MoveDirection> orders1 = List.of(MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD);
        Vector2d expectedBR = new Vector2d(4, 4);

        //upper left test
        Animal testedUL = new Animal(new Vector2d(0, 0));
        List<MoveDirection> orders2 = List.of(MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD);
        Vector2d expectedUL = new Vector2d(0, 0);

        //when
        MapDirection actualO1 = tested1.getOrientation();
        Vector2d actualP1 = tested1.getPosition();

        tested1.move(MoveDirection.FORWARD,validator);
        MapDirection actualO2 = tested1.getOrientation();
        Vector2d actualP2 = tested1.getPosition();

        tested1.move(MoveDirection.BACKWARD,validator);
        MapDirection actualO3 = tested1.getOrientation();
        Vector2d actualP3 = tested1.getPosition();

        tested1.move(MoveDirection.LEFT,validator);
        MapDirection actualO4 = tested1.getOrientation();
        Vector2d actualP4 = tested1.getPosition();

        tested1.move(MoveDirection.FORWARD,validator);
        Vector2d actualP5 = tested1.getPosition();

        tested1.move(MoveDirection.RIGHT,validator);
        tested1.move(MoveDirection.RIGHT,validator);
        MapDirection actualO6 = tested1.getOrientation();
        Vector2d actualP6 = tested1.getPosition();

        tested1.move(MoveDirection.RIGHT,validator);
        MapDirection actualO7 = tested1.getOrientation();


        for (var ord : orders1) {
            testedBR.move(ord,validator);
        }
        Vector2d actualBR = testedBR.getPosition();

        for (var ord : orders2) {
            testedUL.move(ord,validator);
        }
        Vector2d actualUL = testedUL.getPosition();

        //then
        Assertions.assertEquals(expectedO1, actualO1, "Animal should have NORTH orientation after creating");
        Assertions.assertEquals(expectedO2, actualO2, "Animal should have NORTH orientation after moving forward");
        Assertions.assertEquals(expectedO3, actualO3, "Animal should have NORTH orientation after moving backward");
        Assertions.assertEquals(expectedO4, actualO4, "Animal should have WEST orientation after moving left");
        Assertions.assertEquals(expectedO6, actualO6, "Animal should have EAST orientation after moving right 2 times having WEST orientation");
        Assertions.assertEquals(expectedO7, actualO7, "Animal should have SOUTH orientation after moving right having EAST orientation");

        Assertions.assertEquals(expectedP1, actualP1, "Animal should have (2,2) position after creating");
        Assertions.assertEquals(expectedP2, actualP2, "Animal should have (1,2) position after moving forward to North");
        Assertions.assertEquals(expectedP3, actualP3, "Animal should have (2,2) position after moving backward to North");
        Assertions.assertEquals(expectedP4, actualP4, "Animal position should not change after moving left");
        Assertions.assertEquals(expectedP5, actualP5, "Animal should have (2,1) position after moving forward to West");
        Assertions.assertEquals(expectedP6, actualP6, "Animal position should not change after moving right");


        Assertions.assertEquals(expectedBR, actualBR, "Animal should not move if after next move it would cross the border (upper and right)");
        Assertions.assertEquals(expectedUL, actualUL, "Animal should not move if after next move it would cross the border (bottom and left)");
    }
}



