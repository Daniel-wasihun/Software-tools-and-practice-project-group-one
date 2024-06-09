package tools;

import static org.junit.Assert.*;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

// JUnit test class for AnagramChecker
public class AnagramCheckerTest {

    // Test method for sorting strings
    @Test
    public void testSort() {
        // Test case 1: Sorting "cab" should result in "abc"
        assertEquals("abc", AnagramChecker.sort("cab"));
        // Test case 2: Sorting "testing" should result in "eginstt"
        assertEquals("eginstt", AnagramChecker.sort("testing"));
    }

    // Test method for checking anagrams
    @Test
    public void testIsAnagrams() {
        // Test case 1: "abc" and "cab" are anagrams
        assertEquals(true, AnagramChecker.isAnagrams("abc", "cab"));
        // Test case 2: "thought" and "taught" are not anagrams
        assertEquals(false, AnagramChecker.isAnagrams("thought", "taught"));
    }

}