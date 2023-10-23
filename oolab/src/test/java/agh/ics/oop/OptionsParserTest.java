package agh.ics.oop;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class OptionsParserTest {
    @Test
    public void verifyParse() {
        //given
        String[] orders1 = {"f", "l", "r", "d"};
        String[] orders2 = {"f", "wrong", "l"};
        String[] orders3 = {};
        String[] orders4 = {"f", "f", "r", "d", "wrong", "l"};
        List<MoveDirection> expected1 = Arrays.asList(MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.BACKWARD);
        List<MoveDirection> expected2 = Arrays.asList(MoveDirection.FORWARD, MoveDirection.LEFT);
        List<MoveDirection> expected3 = List.of();
        List<MoveDirection> expected4 = Arrays.asList(MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.LEFT);

        //when
        List<MoveDirection> calculated1 = OptionsParser.parse(orders1);
        List<MoveDirection> calculated2 = OptionsParser.parse(orders2);
        List<MoveDirection> calculated3 = OptionsParser.parse(orders3);
        List<MoveDirection> calculated4 = OptionsParser.parse(orders4);

        //then
        Assertions.assertEquals(expected1, calculated1, "Correctly maps to MoveDirections");
        Assertions.assertEquals(expected2, calculated2, "Correctly ignores strings not equals to legal ones");
        Assertions.assertEquals(expected3, calculated3, "Correctly return empty array when no orders were given");
        Assertions.assertEquals(expected4, calculated4, "Correctly maps when legal options are mixed with different ones");
    }
}
