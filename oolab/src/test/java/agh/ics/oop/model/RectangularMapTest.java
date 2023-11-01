package agh.ics.oop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void place() {
        RectangularMap map = new RectangularMap(20, 20);
        Animal placed = new Animal(new Vector2d(2, 2));
        Animal outsideBorder = new Animal(new Vector2d(2, 2));
        Assertions.assertTrue(map.place(placed), "Animal should be placed");
        Assertions.assertFalse(map.place(placed), "Animal should not be placed if position is occupied");
        Assertions.assertFalse(map.place(outsideBorder), "Animal outside the border should not be placed");
    }

    @Test
    void isLegal() {
        RectangularMap map = new RectangularMap(10, 10);
        Vector2d inBound1 = new Vector2d(5, 5);
        Vector2d inBound2 = new Vector2d(5, 10);
        Vector2d inBound3 = new Vector2d(10, 5);
        Vector2d outBound1 = new Vector2d(50, 50);
        Vector2d outBound2 = new Vector2d(-50, -50);

        Assertions.assertTrue(map.isLegal(inBound1));
        Assertions.assertTrue(map.isLegal(inBound2));
        Assertions.assertTrue(map.isLegal(inBound3));

        Assertions.assertFalse(map.isLegal(outBound1));
        Assertions.assertFalse(map.isLegal(outBound2));
    }


    @Test
    void isOccupied() {
        RectangularMap map = new RectangularMap(20, 20);
        for (int i = 0; i < 20; i++)
            for (int j = 0; j < 10; j += 2)
                map.place(new Animal(new Vector2d(i, j)));
        Vector2d occupied = new Vector2d(2, 2);
        Vector2d free = new Vector2d(2, 5);
        Assertions.assertTrue(map.isOccupied(occupied));
        Assertions.assertFalse(map.isOccupied(free));
    }

    @Test
    void objectAt() {
        RectangularMap map = new RectangularMap(20, 20);
        List<Animal> animals = new ArrayList<>();
        for (int i = 0; i < 20; i++)
            for (int j = 0; j < 10; j += 2) {
                Animal temp = new Animal(new Vector2d(i, j));
                animals.add(temp);
                map.place(temp);
            }
        var animalIt = animals.iterator();
        for (int i = 0; i < 20; i++)
            for (int j = 0; j < 10; j += 2) {
                assertEquals(animalIt.next(), map.objectAt(new Vector2d(i, j)));
            }
    }

    @Test
    void canMoveTo() {
        RectangularMap map = new RectangularMap(20, 20);
        List<Animal> animals = new ArrayList<>();
        for (int i = 0; i < 20; i++)
            for (int j = 0; j < 10; j += 2) {
                Animal temp = new Animal(new Vector2d(i, j));
                animals.add(temp);
                map.place(temp);
            }
        Assertions.assertTrue(map.canMoveTo(new Vector2d(0, 1)));
        Assertions.assertFalse(map.canMoveTo(new Vector2d(-1, -1)));
        Assertions.assertFalse(map.canMoveTo(new Vector2d(5, 6)));
    }
}