package ru.stqa.pft.sandbox;

/**
 * Created by ivan8 on 14.05.2017.
 */
public class Point2 {

  public static void main(String[] args) {
    Point1 p1 = new Point1(2.0, 3.0);
    Point1 p2 = new Point1(3.0, 4.0);

    distance(p1, p2);
  }

  public double x;
  public double y;

  public Point2(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public static void distance(Point1 p1, Point1 p2) {
    System.out.println("Расстояние между точками = " +  Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2)));
  }
}
