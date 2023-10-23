package agh.ics.oop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapDirectionTest {
    @Test
    public void verifyNext() {
        Assertions.assertEquals(MapDirection.EAST, MapDirection.NORTH.next(), "Next to NORTH is EAST");
        Assertions.assertEquals(MapDirection.SOUTH, MapDirection.EAST.next(), "Next to EAST is SOUTH");
        Assertions.assertEquals(MapDirection.WEST, MapDirection.SOUTH.next(), "Next to SOUTH is WEST");
        Assertions.assertEquals(MapDirection.NORTH, MapDirection.WEST.next(), "Next to WEST is NORTH");
    }

    @Test
    public void verifyPrevious() {
        Assertions.assertEquals(MapDirection.NORTH, MapDirection.EAST.previous(),"Previous to EAST is NORTHS");
        Assertions.assertEquals(MapDirection.EAST, MapDirection.SOUTH.previous(),"Previous to SOUTH is EAST");
        Assertions.assertEquals(MapDirection.SOUTH, MapDirection.WEST.previous(),"Previous to WEST is SOUTH");
        Assertions.assertEquals(MapDirection.WEST, MapDirection.NORTH.previous(),"Previous to NORTH is WEST");
    }
}
