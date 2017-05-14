package ru.stqa.pft.sandbox;

/**
 * Created by ivan8 on 14.05.2017.
 */
class Start {
  public static void main(String[] args) {

    Point p1 = new Point(2.0, 3.0);
    Point p2 = new Point(3.0, 4.0);

    System.out.println("Расстояние между точками =" + Point.distance(p1, p2));
  }
}

public class Point {

  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public static double distance(Point p1, Point p2) {
    return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
  }
}
