package agh.ics.oop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Vector2dTest {
    @Test
    public void verifyEquals() {
        Vector2d main = new Vector2d(1, 1);
        int t = 1;
        Vector2d another = new Vector2d(1,2);
        Vector2d same = new Vector2d(1,1);
        Assertions.assertTrue(main.equals(main)); //equals to itself
        Assertions.assertFalse(main.equals(t)); //not equals to another object type
        Assertions.assertFalse(main.equals(another)); //not equals if different x,y values
        Assertions.assertTrue(main.equals(same)); //equals if the instances of Vector2d and have the same x,y
    }

    @Test
    public void verifyToString() {
        Vector2d main = new Vector2d(1,1);
        Assertions.assertEquals(main.toString(),"(1,1)");
        main = new Vector2d(-1,1);
        Assertions.assertEquals(main.toString(),"(-1,1)");
        main = new Vector2d(1,-1);
        Assertions.assertEquals(main.toString(),"(1,-1)");
        main = new Vector2d(-1,-1);
        Assertions.assertEquals(main.toString(),"(-1,-1)");
    }

    @Test
    public void verifyPrecedes() {
        Vector2d main = new Vector2d(1,1);
        Vector2d secondary = new Vector2d(2,2);
        Assertions.assertTrue(main.precedes(secondary));

        secondary = new Vector2d(0,0);
        Assertions.assertFalse(main.precedes(secondary));

        secondary = new Vector2d(1,1);
        Assertions.assertTrue(main.precedes(secondary));

        secondary = new Vector2d(2,0);
        Assertions.assertFalse(main.precedes(secondary));

        secondary = new Vector2d(0,2);
        Assertions.assertFalse(main.precedes(secondary));

    }

    @Test
    public void verifyFollows() {
        Vector2d main = new Vector2d(1,1);
        Vector2d secondary = new Vector2d(2,2);
        Assertions.assertFalse(main.follows(secondary));

        secondary = new Vector2d(0,0);
        Assertions.assertTrue(main.follows(secondary));

        secondary = new Vector2d(1,1);
        Assertions.assertTrue(main.follows(secondary));

        secondary = new Vector2d(2,0);
        Assertions.assertFalse(main.follows(secondary));

        secondary = new Vector2d(0,2);
        Assertions.assertFalse(main.follows(secondary));
    }

    @Test
    public void verifyUpperRight() {
        Vector2d main = new Vector2d(4,20);
        Vector2d secondary = new Vector2d(10,2);
        Assertions.assertEquals(main.upperRight(secondary),new Vector2d(10,20));
        Assertions.assertEquals(secondary.upperRight(main),new Vector2d(10,20));
    }

    @Test
    public void verifyLowerLeft() {
        Vector2d main = new Vector2d(4,20);
        Vector2d secondary = new Vector2d(10,2);
        Assertions.assertEquals(main.lowerLeft(secondary),new Vector2d(4,2));
        Assertions.assertEquals(secondary.lowerLeft(main),new Vector2d(4,2));
    }

    @Test
    public void verifyAdd() {
        Vector2d main = new Vector2d(4,20);
        Vector2d secondary = new Vector2d(10,2);
        Assertions.assertEquals(main.add(secondary), new Vector2d(14,22));
        Assertions.assertEquals(secondary.add(main), new Vector2d(14,22));
    }

    @Test
    public void verifySubtract() {
        Vector2d main = new Vector2d(4,20);
        Vector2d secondary = new Vector2d(10,2);
        Assertions.assertEquals(main.subtract(secondary), new Vector2d(-6,18));
        Assertions.assertEquals(secondary.subtract(main), new Vector2d(6,-18));
    }


    @Test
    public void verifyOpposite() {
        //given
        Vector2d main1 = new Vector2d(4,20);
        Vector2d main2 = new Vector2d(-4,-20);
        Vector2d expected1 = new Vector2d(-4,-20);
        Vector2d expected2 = new Vector2d(4,20);

        //when
        Vector2d calculated1 = main1.opposite();
        Vector2d calculated2 = main2.opposite();

        //then
        Assertions.assertEquals(calculated1,expected1);
        Assertions.assertEquals(calculated2,expected2);
    }

}
