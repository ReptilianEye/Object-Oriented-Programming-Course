package agh.ics.oop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.List;


class TextMapTest {

    @Test
    void place() {
        TextMap map = new TextMap();
        List<String> elements = List.of("Ala", "ma", "Kota");
//        System.out.println(map);
        for (var el : elements) {
            map.place(el);
//            System.out.println(map);
        }
        var mapAfter = map.getMap();
        for (int i = 0; i < elements.size(); i++) {
            Assertions.assertEquals(mapAfter.get(i).getKey(), elements.get(i));
            Assertions.assertEquals(mapAfter.get(i).getValue(), MapDirection.EAST);
        }
    }

    @Test
    void move() {
        TextMap map = new TextMap();
        String s1 = "Ala";
        String s2 = "ma";
        String s3 = "kota";

        List<String> elements = List.of(s1, s2, s3);
        for (var el : elements) {
            map.place(el);
        }
        List<AbstractMap.SimpleEntry> expected = List.of(new AbstractMap.SimpleEntry(s1, MapDirection.WEST), new AbstractMap.SimpleEntry(s3, MapDirection.EAST), new AbstractMap.SimpleEntry(s2, MapDirection.EAST));
        map.move(s1, MoveDirection.BACKWARD);
        map.move(s2, MoveDirection.FORWARD);
        map.move(s2, MoveDirection.FORWARD);
        map.move(s3, MoveDirection.BACKWARD);
        map.move(s1, MoveDirection.LEFT);
        map.move(s1, MoveDirection.LEFT);
        map.move(s1, MoveDirection.FORWARD);
//        System.out.println(map);

        var mapAfter = map.getMap();
        for (int i = 0; i < elements.size(); i++) {
            Assertions.assertEquals(mapAfter.get(i), expected.get(i));
        }
    }

    @Test
    void isOccupied() {
        TextMap map = new TextMap();
        String s1 = "Ala";
        String s2 = "ma";
        String s3 = "kota";
        List<String> elements = List.of(s1, s2, s3);
        for (var el : elements) {
            map.place(el);
        }
        Assertions.assertTrue(map.isOccupied(0));
        Assertions.assertTrue(map.isOccupied(1));
        Assertions.assertTrue(map.isOccupied(2));
        Assertions.assertFalse(map.isOccupied(-1));
        Assertions.assertFalse(map.isOccupied(3));
    }

    @Test
    void objectAt() {
        TextMap map = new TextMap();
        String s1 = "Ala";
        String s2 = "ma";
        String s3 = "kota";
        List<String> elements = List.of(s1, s2, s3);
        for (var el : elements) {
            map.place(el);
        }
        for (int i = 0; i < elements.size(); i++) {
            Assertions.assertEquals(elements.get(i), map.objectAt(i));
        }
    }

    @Test
    void canMoveTo() {
        isOccupied();
    }
}