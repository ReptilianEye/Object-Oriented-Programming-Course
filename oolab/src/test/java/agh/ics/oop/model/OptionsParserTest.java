package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OptionsParserTest {
    @Test
    public void verifyParse() {
        //given
        String[] orders1 = {"f", "l", "r", "d"};
        String[] orders2 = {"f", "wrong", "l"};
        String[] orders3 = {};
        String[] orders4 = {"f", "f", "r", "d", "wrong", "l"};
        MoveDirection[] expected1 = new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.BACKWARD};
        MoveDirection[] expected2 = new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.LEFT};
        MoveDirection[] expected3 = new MoveDirection[]{};
        MoveDirection[] expected4 = new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.LEFT};

        //when
        MoveDirection[] calculated1 = OptionsParser.parse(orders1);
        MoveDirection[] calculated2 = OptionsParser.parse(orders2);
        MoveDirection[] calculated3 = OptionsParser.parse(orders3);
        MoveDirection[] calculated4 = OptionsParser.parse(orders4);

        //then
        Assertions.assertArrayEquals(expected1, calculated1, "Correctly maps to MoveDirections");
        Assertions.assertArrayEquals(expected2, calculated2, "Correctly ignores strings not equals to legal ones");
        Assertions.assertArrayEquals(expected3, calculated3, "Correctly return empty array when no orders were given");
        Assertions.assertArrayEquals(expected4, calculated4, "Correctly maps when legal options are mixed with different ones");
    }
}
