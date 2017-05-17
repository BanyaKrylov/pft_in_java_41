package ru.stqa.pft.sandbox;

/**
 * Created by ivan8 on 14.05.2017.
 */
class Start2 {
  public static void main(String[] args) {

      Point2 p1 = new Point2(2.0, 3.0);
      Point2 p2 = new Point2(3.0, 4.0);

      p1.distance(p2);
  }
}
    public class Point2 {


      public double x;
      public double y;

      public Point2(double x, double y) {
        this.x = x;
        this.y = y;
      }

      public void distance(Point2 p2) {
        System.out.println("Расстояние между точками = " + Math.sqrt(Math.pow(p2.x - this.x, 2) + Math.pow(p2.y - this.y, 2)));
      }
    }

