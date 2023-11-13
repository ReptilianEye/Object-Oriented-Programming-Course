package agh.ics.oop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    @Test
    void testIsOccupied() {
        GrassField map = new GrassField(10);
        assertFalse(map.isOccupied(new Vector2d(2, 2)));
        assertFalse(map.isOccupied(new Vector2d(1, 5)));
        assertFalse(map.isOccupied(new Vector2d(6, 2)));
        assertFalse(map.isOccupied(new Vector2d(10, 1)));
        assertFalse(map.isOccupied(new Vector2d(2, 42)));
        assertFalse(map.isOccupied(new Vector2d(0, 2)));
        assertFalse(map.isOccupied(new Vector2d(5, 4)));
        assertFalse(map.isOccupied(new Vector2d(0, 0)));
        assertFalse(map.isOccupied(new Vector2d(9, 9)));

        Animal animal = new Animal(new Vector2d(2, 2));
        try {
            map.place(animal);
        } catch (
                PositionAlreadyOccupiedException e) {

        }

        assertTrue(map.isOccupied(new Vector2d(2, 2)));
        assertFalse(map.isOccupied(new Vector2d(1, 5)));
        assertFalse(map.isOccupied(new Vector2d(6, 2)));
        assertFalse(map.isOccupied(new Vector2d(10, 1)));
        assertFalse(map.isOccupied(new Vector2d(2, 42)));
        assertFalse(map.isOccupied(new Vector2d(0, 2)));
        assertFalse(map.isOccupied(new Vector2d(5, 4)));
        assertFalse(map.isOccupied(new Vector2d(0, 0)));
        assertFalse(map.isOccupied(new Vector2d(9, 9)));
    }

    @Test
    void testObjectAt() {
        GrassField map = new GrassField(10);
        Iterator it = map.getElements().iterator();
        it.next();
        HashMap grasses = (HashMap) it.next();
        for (var grass : grasses.values()) {
            Assertions.assertTrue(grass instanceof Grass);
        }
        Animal animal = new Animal(new Vector2d(2, 2));
        try {
            map.place(animal);
        } catch (
                PositionAlreadyOccupiedException ignored) {
        }
        assertEquals(animal, map.objectAt(new Vector2d(2, 2)));
        assertFalse(map.objectAt(new Vector2d(3, 4)) instanceof Animal);
        assertFalse(map.objectAt(new Vector2d(0, 0)) instanceof Animal);
        assertFalse(map.objectAt(new Vector2d(9, 9)) instanceof Animal);
    }

    @Test
    void testCanMoveTo() {
        GrassField map = new GrassField(10);
        assertTrue(map.canMoveTo(new Vector2d(2, 2)));
        assertTrue(map.canMoveTo(new Vector2d(1, 5)));
        assertTrue(map.canMoveTo(new Vector2d(6, 2)));
        assertTrue(map.canMoveTo(new Vector2d(10, 1)));
        assertTrue(map.canMoveTo(new Vector2d(2, 42)));
        assertTrue(map.canMoveTo(new Vector2d(0, 2)));
        assertTrue(map.canMoveTo(new Vector2d(5, 4)));
        assertTrue(map.canMoveTo(new Vector2d(0, 0)));
        assertTrue(map.canMoveTo(new Vector2d(9, 9)));

        Animal animal = new Animal(new Vector2d(2, 2));
        try {
            map.place(animal);
        } catch (
                PositionAlreadyOccupiedException ignored) {
        }

        assertFalse(map.canMoveTo(new Vector2d(2, 2)));
        assertTrue(map.canMoveTo(new Vector2d(3, 4)));
        assertTrue(map.canMoveTo(new Vector2d(0, 0)));
        assertTrue(map.canMoveTo(new Vector2d(9, 9)));
    }
}