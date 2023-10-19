package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OptionsParserTest {
    @Test
    public void verifyParse() {
        //gived
        String[] orders = {"f", "f", "r", "d", "wrong", "l"};
        MoveDirection[] expected = new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.LEFT};

        //when
        MoveDirection[] calculated = OptionsParser.parse(orders);

        //then
        Assertions.assertArrayEquals(calculated, expected);
    }
}
