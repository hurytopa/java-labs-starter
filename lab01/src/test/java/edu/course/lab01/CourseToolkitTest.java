package edu.course.lab01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CourseToolkitTest {
//Even
    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);

        assertFalse(result);
    }

    @Test
    void returnsTrueForNegativeEvenNumber() {
        boolean result = CourseToolkit.isEven(-8);

        assertTrue(result);
    }
//Prime
    @Test
    void returnsFalseForNumberBelowTwo() {
        assertFalse(CourseToolkit.isPrime(1));
        assertFalse(CourseToolkit.isPrime(0));
        assertFalse(CourseToolkit.isPrime(-7));
    }
    
    @Test
    void returnsTrueForTwo() {
        assertTrue(CourseToolkit.isPrime(2));
    }

    @Test
    void returnsFalseForCompositeNumber() {
        assertFalse(CourseToolkit.isPrime(15));
    }

    @Test
    void returnsFalseForSquareOfPrime() {
        assertFalse(CourseToolkit.isPrime(49));
    }

    @Test
    void returnsTrueForLargePrime() {
        assertTrue(CourseToolkit.isPrime(97));
    }
//Palindrome
    @Test
    void returnsTrueForPalindrome() {
        assertTrue(CourseToolkit.isPalindrome("level"));
    }
    @Test
    void returnsFalseForNonPalindrome() {
        assertFalse(CourseToolkit.isPalindrome("java"));
    }

    @Test
    void returnsFalseWhenCaseDiffers() {
        assertFalse(CourseToolkit.isPalindrome("Level"));
    }

    @Test
    void returnsFalseWhenSpacesDiffer() {
        assertFalse(CourseToolkit.isPalindrome("level "));
    }

    @Test
    void returnsTrueForSingleCharacter() {
        assertTrue(CourseToolkit.isPalindrome("a"));
    }

    @Test
    void throwsForNullText() {
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.isPalindrome(null));
    }
//Average
    @Test
    void returnsAverageOfWholeNumbers() {
        assertEquals(4.0, CourseToolkit.average(new int[]{2, 4, 6}), 1e-9);
    }

    @Test
    void returnsFractionalAverage() {
        assertEquals(1.5, CourseToolkit.average(new int[]{1, 2}), 1e-9);
    }

    @Test
    void returnsAverageOfNegativeNumbers() {
        assertEquals(-3.0, CourseToolkit.average(new int[]{-2, -4}), 1e-9);
    }

    @Test
    void returnsValueForSingleElement() {
        assertEquals(7.0, CourseToolkit.average(new int[]{7}), 1e-9);
    }

    @Test
    void throwsForNullArray() {
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.average(null));
    }

    @Test
    void throwsForEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.average(new int[0]));
    }

    @Test
    void doesNotModifyInputArray() {
        int[] values = {1, 2, 4};
        int[] expected = {1, 2, 4};

        CourseToolkit.average(values);

        assertArrayEquals(expected, values);
    }
}