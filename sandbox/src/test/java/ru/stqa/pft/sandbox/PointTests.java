package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by ivan8 on 14.05.2017.
 */
public class PointTests {

  @Test

  public void testArea() {
    Point1 p1 = new Point1(2.0, 3.0);
    Point1 p2 = new Point1(3.0, 4.0);

    Assert.assertEquals(Point1.distance(p1, p2), 1.4142135623730951);
  }

  @Test

  public void testArea1() {
    Point1 p1 = new Point1(2.5, 3.5);
    Point1 p2 = new Point1(3.0, 4.0);

    Assert.assertEquals(Point1.distance(p1, p2), 0.7071067811865476);
  }

}
