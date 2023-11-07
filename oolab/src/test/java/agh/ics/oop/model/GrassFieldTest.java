package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

@Test
void testIsOccupied() {
    GrassField map = new GrassField(10);
    assertFalse(map.isOccupied(new Vector2d(2, 2)));
    assertFalse(map.isOccupied(new Vector2d(3, 4)));
    assertFalse(map.isOccupied(new Vector2d(0, 0)));
    assertFalse(map.isOccupied(new Vector2d(9, 9)));

    Animal animal = new Animal(map, new Vector2d(2, 2));
    map.place(animal);

    assertTrue(map.isOccupied(new Vector2d(2, 2)));
    assertFalse(map.isOccupied(new Vector2d(3, 4)));
    assertFalse(map.isOccupied(new Vector2d(0, 0)));
    assertFalse(map.isOccupied(new Vector2d(9, 9)));
}

@Test
void testObjectAt() {
    GrassField map = new GrassField(10);
    assertNull(map.objectAt(new Vector2d(2, 2)));
    assertNull(map.objectAt(new Vector2d(3, 4)));
    assertNull(map.objectAt(new Vector2d(0, 0)));
    assertNull(map.objectAt(new Vector2d(9, 9)));

    Animal animal = new Animal(map, new Vector2d(2, 2));
    map.place(animal);

    assertEquals(animal, map.objectAt(new Vector2d(2, 2)));
    assertNull(map.objectAt(new Vector2d(3, 4)));
    assertNull(map.objectAt(new Vector2d(0, 0)));
    assertNull(map.objectAt(new Vector2d(9, 9)));
}

@Test
void testCanMoveTo() {
    GrassField map = new GrassField(10);
    assertTrue(map.canMoveTo(new Vector2d(2, 2)));
    assertTrue(map.canMoveTo(new Vector2d(3, 4)));
    assertTrue(map.canMoveTo(new Vector2d(0, 0)));
    assertTrue(map.canMoveTo(new Vector2d(9, 9)));

    Animal animal = new Animal(map, new Vector2d(2, 2));
    map.place(animal);

    assertFalse(map.canMoveTo(new Vector2d(2, 2)));
    assertTrue(map.canMoveTo(new Vector2d(3, 4)));
    assertTrue(map.canMoveTo(new Vector2d(0, 0)));
    assertTrue(map.canMoveTo(new Vector2d(9, 9)));
}}