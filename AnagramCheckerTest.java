package tools;

import static org.junit.Assert.*;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnagramCheckerTest {

    @Test

    public void testSort() {
        assertEquals("abc", AnagramChecker.sort("cab"));
        assertEquals("eginstt", AnagramChecker.sort("testing"));
    }

    @Test
    public void testIsAnagrams() {
        assertEquals(true, AnagramChecker.isAnagrams("abc", "cab"));
        assertEquals(false, AnagramChecker.isAnagrams("thought", "taught"));
    }

}