package org.assignment;

import java.util.Arrays;
import org.assignment.util.TextUtil;

public class Main {
  public static void main(String[] args) {
    try {
      boolean areAnagrams = TextUtil.areAnagrams(Arrays.asList(args));
      if (areAnagrams) {
        System.out.println("Yay, the texts are anagrams! :)");
      } else {
        System.out.println("Sorry, the texts are not anagrams :(");
      }
    } catch (IllegalArgumentException e) {
      System.out.println("Please provide at least 2 texts.");
    }
  }
}
