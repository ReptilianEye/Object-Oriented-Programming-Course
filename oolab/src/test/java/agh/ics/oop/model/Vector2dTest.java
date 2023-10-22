package agh.ics.oop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Vector2dTest {
    @Test
    public void verifyEquals() {
        Vector2d main = new Vector2d(1, 1);
        int t = 1;
        Vector2d another = new Vector2d(1, 2);
        Vector2d same = new Vector2d(1, 1);
        Assertions.assertTrue(main.equals(main), "Should be equal with itself");
        Assertions.assertFalse(main.equals(t), "Should not be equals with object of different type");
        Assertions.assertFalse(main.equals(another), "Should not be equals with Vector2d of different coordinates");
        Assertions.assertTrue(main.equals(same), "Should be equals with Vector2d of the same coordinates");
    }

    @Test
    public void verifyHash() {
        int main = new Vector2d(1, 1).hashCode();
        int main2 = new Vector2d(1, 1).hashCode();
        int different = new Vector2d(1, 2).hashCode();
        int expected = new Vector2d(1, 1).hashCode();
        Assertions.assertEquals(main2, main, "The hashcodes of the same instances should be equals");
        Assertions.assertNotEquals(different, main, "The hashcodes of two Vector2d objects with different coordinates should not be equal");
        Assertions.assertEquals(expected, main, "The hashcodes of two vectors with same coordinates should be the same");
    }

    @Test
    public void verifyToString() {
        String mainString = new Vector2d(1, 1).toString();
        Assertions.assertEquals("(1,1)", mainString, "String of vector of coordinates x,y should be (x,y)");
        mainString = new Vector2d(-1, 1).toString();
        Assertions.assertEquals("(-1,1)", mainString, "String of vector of coordinates -x,y should be (-x,y)");
        mainString = new Vector2d(1, -1).toString();
        Assertions.assertEquals("(1,-1)", mainString, "String of vector of coordinates x,-y should be (x,-y)");
        mainString = new Vector2d(-1, -1).toString();
        Assertions.assertEquals("(-1,-1)", mainString, "String of vector of coordinates -x,-y should be (-x,-y)");
    }

    @Test
    public void verifyPrecedes() {
        Vector2d prev = new Vector2d(1, 1);
        Vector2d next = new Vector2d(2, 2);
        Assertions.assertTrue(prev.precedes(next), "(x1,y1) precedes (x2,y2) where x1 < x2 and y1 < y2");

        next = new Vector2d(0, 0);
        Assertions.assertFalse(prev.precedes(next), "(x1,y1) does not precede (x2,y2) where x1 > x2 and y1 > y2");

        next = new Vector2d(1, 1);
        Assertions.assertTrue(prev.precedes(next), "(x1,y1) precedes (x2,y2) where x1 = x2 and y1 = y2");

        next = new Vector2d(2, 0);
        Assertions.assertFalse(prev.precedes(next), "(x1,y1) does not precede (x2,y2) where x1 < x2 and y1 > y2");

        next = new Vector2d(0, 2);
        Assertions.assertFalse(prev.precedes(next), "(x1,y1) does not precede (x2,y2) where x1 > x2 and y1 < y2");

    }

    @Test
    public void verifyFollows() {
        Vector2d next = new Vector2d(1, 1);
        Vector2d prev = new Vector2d(2, 2);
        Assertions.assertFalse(next.follows(prev), "(x1,y1) does not follow (x2,y2) where x1 < x2 and y1 < y2");

        prev = new Vector2d(0, 0);
        Assertions.assertTrue(next.follows(prev), "(x1,y1) follow (x2,y2) where x1 > x2 and y1 > y2");

        prev = new Vector2d(1, 1);
        Assertions.assertTrue(next.follows(prev), "(x1,y1) follow (x2,y2) where x1 = x2 and y1 = y2");

        prev = new Vector2d(2, 0);
        Assertions.assertFalse(next.follows(prev), "(x1,y1) does not follow (x2,y2) where x1 < x2 and y1 > y2");

        prev = new Vector2d(0, 2);
        Assertions.assertFalse(next.follows(prev), "(x1,y1) does not follow (x2,y2) where x1 > x2 and y1 < y2");
    }

    @Test
    public void verifyUpperRight() {
        //given
        Vector2d main = new Vector2d(4, 20);
        Vector2d secondary = new Vector2d(10, 2);
        Vector2d expected1 = new Vector2d(10, 20);
        Vector2d expected2 = new Vector2d(10, 20);

        //when
        Vector2d upperRight1 = main.upperRight(secondary);
        Vector2d upperRight2 = secondary.upperRight(main);

        //then
        Assertions.assertEquals(expected1, upperRight1, "Upper right from (x1,y1) and (x2,y2) should be (x2,y1) where x1 < x2 and y1 > y2");
        Assertions.assertEquals(expected2, upperRight2, "Upper right from (x1,y1) and (x2,y2) should be (x1,y2) where x1 > x2 and y1 < y2");
    }

    @Test
    public void verifyLowerLeft() {
        //given
        Vector2d main = new Vector2d(4, 20);
        Vector2d secondary = new Vector2d(10, 2);
        Vector2d expected1 = new Vector2d(4, 2);
        Vector2d expected2 = new Vector2d(4, 2);

        //when
        Vector2d lowerLeft1 = main.lowerLeft(secondary);
        Vector2d lowerLeft2 = secondary.lowerLeft(main);


        Assertions.assertEquals(expected1, lowerLeft1, "Lower left from (x1,y1) and (x2,y2) should be (x1,y2) where x1 < x2 and y1 > y2");
        Assertions.assertEquals(expected2, lowerLeft2, "Lower left from (x1,y1) and (x2,y2) should be (x2,y1) where x1 > x2 and y1 < y2");
    }

    @Test
    public void verifyAdd() {
        //given
        Vector2d main = new Vector2d(4, 20);
        Vector2d secondary = new Vector2d(10, 2);
        Vector2d expected = new Vector2d(14, 22);
        //when
        Vector2d sum = main.add(secondary);

        //then
        Assertions.assertEquals(expected, sum, "Sum vector from (x1,y1) and (x2,y2) should be (x1+x2,y1+y2)");
    }

    @Test
    public void verifySubtract() {
        //given
        Vector2d main = new Vector2d(4, 20);
        Vector2d secondary = new Vector2d(10, 2);
        Vector2d expected1 = new Vector2d(-6, 18);
        Vector2d expected2 = new Vector2d(6, -18);

        //when
        Vector2d sub1 = main.subtract(secondary);
        Vector2d sub2 = secondary.subtract(main);

        //then
        Assertions.assertEquals(expected1, sub1, "Difference vector from (x1,y1) and (x2,y2) should be (x1-x2,y1-y2) (test1)");
        Assertions.assertEquals(expected2, sub2, "Difference vector from (x1,y1) and (x2,y2) should be (x1-x2,y1-y2) (test2)");
    }


    @Test
    public void verifyOpposite() {
        //given
        Vector2d main1 = new Vector2d(4, 20);
        Vector2d main2 = new Vector2d(-4, -20);
        Vector2d expected1 = new Vector2d(-4, -20);
        Vector2d expected2 = new Vector2d(4, 20);

        //when
        Vector2d calculated1 = main1.opposite();
        Vector2d calculated2 = main2.opposite();

        //then
        Assertions.assertEquals(expected1, calculated1, "Opposite vector from (x1,y1) should be (-x1,-y1) (test1)");
        Assertions.assertEquals(expected2, calculated2, "Opposite vector from (x1,y1) should be (-x1,-y1) (test2)");
    }

}
