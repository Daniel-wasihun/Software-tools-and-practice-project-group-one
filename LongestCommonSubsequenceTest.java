package tools;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LongestCommonSubsequenceTest {

    // This method tests the findLCS() method of the LongestCommonSubsequence class
    @Test
    public void testFindLCS() {
        // Creating an instance of the LongestCommonSubsequence class
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();

        // Input strings
        String string1 = "ABCBDAB";
        String string2 = "BDCABA";

        // Expected result
        String expectedLCS = "BCBA";

        // Calling the method under test
        String actualLCS = lcs.findLCS(string1, string2);

        // Asserting that the actual result matches the expected result
        assertEquals(expectedLCS, actualLCS);
    }
}

