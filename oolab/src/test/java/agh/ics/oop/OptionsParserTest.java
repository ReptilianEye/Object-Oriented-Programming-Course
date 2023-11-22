package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class OptionsParserTest {
    @Test
    public void verifyParse() {
        String errorEnd = " is not legal move specification";
        //given
        String[] orders1 = {"f", "l", "r", "b"};
        String[] orders2 = {"f", "wrong", "l"};
        String[] orders3 = {};
        String[] orders4 = {"f", "f", "r", "b", "tomek", "l"};
        List<MoveDirection> expected1 = Arrays.asList(MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.BACKWARD);
//        List<MoveDirection> expected2 = Arrays.asList(MoveDirection.FORWARD, MoveDirection.LEFT);
        String expected2Message = "wrong" + errorEnd;
        List<MoveDirection> expected3 = List.of();
        String expected4Message = "tomek" + errorEnd;
        //        List<MoveDirection> expected4 = Arrays.asList(MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.LEFT);

        //when
        List<MoveDirection> calculated1 = OptionsParser.parse(orders1);
        List<MoveDirection> calculated3 = OptionsParser.parse(orders3);
//        List<MoveDirection> calculated2 = OptionsParser.parse(orders2);
//        List<MoveDirection> calculated4 = OptionsParser.parse(orders4);

        Exception ex2 =  Assertions.assertThrows(IllegalArgumentException.class, () -> {
            OptionsParser.parse(orders2);
        });
        Exception ex4 =  Assertions.assertThrows(IllegalArgumentException.class, () -> {
            OptionsParser.parse(orders4);
        });

        //then
        Assertions.assertEquals(expected1, calculated1, "Correctly maps to MoveDirections");
        Assertions.assertEquals(expected2Message,ex2.getMessage(),"Correctly throws IllegalArgumentException");
        Assertions.assertEquals(expected3, calculated3, "Correctly return empty array when no orders were given");
        Assertions.assertEquals(expected4Message,ex4.getMessage(),"Correctly throws IllegalArgumentException");
    }
}
