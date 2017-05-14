package ru.stqa.pft.sandbox;

/**
 * Created by ivan8 on 14.05.2017.
 */
public class Point2 {

  public static void main(String[] args) {
    distance(2.0, 3.0, 3.0, 4.0);
  }

  public static void distance(double x1, double x2, double y1, double y2) {
    System.out.println("Расстояние между точками = " + Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
  }
}
