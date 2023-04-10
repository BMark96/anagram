package util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.assignment.util.TextUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TextUtilTest {
  @Test
  void testAreAnagramsShouldThrowExceptionWhenNoTextAvailable() {
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              TextUtil.areAnagrams(Collections.emptyList());
            });

    String expectedMessage = "Argument list must contain at least 2 texts.";
    assertEquals(exception.getMessage(), expectedMessage);
  }

  @Test
  void testAreAnagramsShouldThrowExceptionWhenOneTextAvailable() {
    List<String> text = List.of("testText");
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              TextUtil.areAnagrams(text);
            });

    String expectedMessage = "Argument list must contain at least 2 texts.";
    assertEquals(exception.getMessage(), expectedMessage);
  }

  @ParameterizedTest
  @MethodSource("argumentsForAnagrams")
  void testAreAnagramsShouldReturnTrue(List<String> texts) {
    assertTrue(TextUtil.areAnagrams(texts));
  }

  @ParameterizedTest
  @MethodSource("argumentsForNotAnagrams")
  void testAreAnagramsShouldReturnFalse(List<String> texts) {
    assertFalse(TextUtil.areAnagrams(texts));
  }

  static Stream<Arguments> argumentsForAnagrams() {
    return Stream.of(
        Arguments.of(List.of("test", "test")),
        Arguments.of(List.of("abc-test", "test-abc")),
        Arguments.of(List.of("test", "tset", "sett")),
        Arguments.of(List.of("TeSt", "SetT")),
        Arguments.of(List.of("Te st", " Test")),
        Arguments.of(List.of("123.?-ő", "ő-123?.")),
        Arguments.of(List.of("te-st", "-test", "test-", "tset-", "-sett", "ttes-", "t-est")));
  }

  static Stream<Arguments> argumentsForNotAnagrams() {
    return Stream.of(
        Arguments.of(List.of("test-def", "abc-test")),
        Arguments.of(List.of("tEst", "test")),
        Arguments.of(List.of("test", "test", "test", "test", "testt")),
        Arguments.of(List.of("12345,", "12345.")),
        Arguments.of(List.of("test ", "test  ")),
        Arguments.of(List.of("ő", "ö")));
  }
}
