package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {


    @Test
    public void testForTwoPointsWithDifferentCoordinates() {
        Point p1 = new Point(0,0);
        Point p2 = new Point(1,1);
        Assert.assertEquals(Math.round(p1.distance(p2)), 1);
    }

    @Test
    public void testForTwoPointsWithDifferentCoordinatesIncludingNegativeValues() {
        Point p1 = new Point(-1,4);
        Point p2 = new Point(-2,-3);
        Assert.assertEquals(Math.round(p1.distance(p2)), 7);
    }

    @Test
    public void testForTwoPointsWithEqualCoordinates() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 0);
        Assert.assertEquals(Math.round(p1.distance(p2)), 0);
    }

    @Test
    public void testForInversionEqualityOfTwoPoints(){
        Point p1 = new Point(2,4);
        Point p2 = new Point(3,5);
        Assert.assertEquals((p1.distance(p2)), p2.distanceInverse(p1));
    }

}
