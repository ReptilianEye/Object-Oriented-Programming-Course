package agh.ics.oop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapDirectionTest {
    @Test
    public void verifyNext(){
        Assertions.assertEquals(MapDirection.NORTH.next(),MapDirection.EAST);
        Assertions.assertEquals(MapDirection.EAST.next(),MapDirection.SOUTH);
        Assertions.assertEquals(MapDirection.SOUTH.next(),MapDirection.WEST);
        Assertions.assertEquals(MapDirection.WEST.next(),MapDirection.NORTH);
    }
    @Test
    public void verifyPrevious(){
        Assertions.assertEquals(MapDirection.NORTH,MapDirection.EAST.previous());
        Assertions.assertEquals(MapDirection.EAST,MapDirection.SOUTH.previous());
        Assertions.assertEquals(MapDirection.SOUTH,MapDirection.WEST.previous());
        Assertions.assertEquals(MapDirection.WEST,MapDirection.NORTH.previous());
    }
}
