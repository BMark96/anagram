package org.assignment.util;

import java.util.Arrays;
import java.util.List;

/** Utility class for operations on texts. */
public class TextUtil {
  /**
   * Returns a boolean which represents if the provided texts are anagrams.
   *
   * @param texts A List of Strings to be tested. Must contain at least 2 Strings.
   * @return A boolean which is true if the texts are anagrams and false otherwise.
   * @throws IllegalArgumentException If less than 2 Strings are provided in the input List.
   */
  public static boolean areAnagrams(List<String> texts) throws IllegalArgumentException {
    if (texts.size() < 2) {
      throw new IllegalArgumentException("Argument list must contain at least 2 texts.");
    }

    String referenceCharacters = sortText(texts.get(0));
    for (String text : texts.subList(1, texts.size())) {
      if (!sortText(text).equals(referenceCharacters)) return false;
    }

    return true;
  }

  /**
   * Returns a String which is the sorted version of the input String.
   *
   * @param text A String to be sorted.
   * @return A String which is the sorted version of the input.
   */
  private static String sortText(String text) {
    char[] textAsArray = text.toCharArray();
    Arrays.sort(textAsArray);
    return new String(textAsArray);
  }
}
