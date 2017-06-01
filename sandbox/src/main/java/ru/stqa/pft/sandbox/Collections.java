package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ivan8 on 01.06.2017.
 */
public class Collections {

  public static void main(String[] args) {
    String[] langs = {"java", "c#", "phyton", "php"};

    List<String> languages = Arrays.asList("java", "c#", "phyton", "php");

    for (String l : languages) {
      System.out.println("Я хочу выучить " + l);
    }
  }
}
