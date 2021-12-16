import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        String d1 = "a";
        boolean actual1 = palindrome.isPalindrome(d1);
        assertTrue(actual1);

        String d2 = "racecar";
        boolean actual2 = palindrome.isPalindrome(d2);
        assertTrue(actual2);

        String d3 = "_3 3_";
        boolean actual3 = palindrome.isPalindrome(d3);
        assertTrue(actual3);

        String d4 = "horse";
        boolean actual4 = palindrome.isPalindrome(d4);
        assertFalse(actual4);

    }

    static CharacterComparator offshow = new OffByOne();

    @Test
    public void testIspalindromeN() {
        String d1 = "a";
        boolean actual1 = palindrome.isPalindrome(d1, offshow);
        assertTrue(actual1);

        String d2 = "flake";
        boolean actual2 = palindrome.isPalindrome(d2, offshow);
        assertTrue(actual2);

        String d3 = "__";
        boolean actual3 = palindrome.isPalindrome(d3, offshow);
        assertFalse(actual3);

        String d4 = "";
        boolean actual4 = palindrome.isPalindrome(d4, offshow);
        assertTrue(actual4);
    }


}
