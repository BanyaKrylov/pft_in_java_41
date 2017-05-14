package ru.stqa.pft.sandbox;

/**
 * Created by ivan8 on 14.05.2017.
 */
class Start {
  public static void main(String[] args) {

    Point1 p1 = new Point1(2.0, 3.0);
    Point1 p2 = new Point1(3.0, 4.0);

    System.out.println("Расстояние между точками = " + Point1.distance(p1, p2));
  }
}

public class Point1 {

  public double x;
  public double y;

  public Point1(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public static double distance(Point1 p1, Point1 p2) {
    return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
  }
}
