package tools;

import java.util.Scanner;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        // Create a Scanner object to read scann from the user
        Scanner scann = new Scanner(System.in);

        // Prompt the user to enter the first word
        System.out.print("Enter the first Word:");
        String stringOne = scann.nextLine();

        // Prompt the user to enter the second word
        System.out.print("Enter the second Word:");
        String stringTwo = scann.nextLine();

        // Find the longest common subsequence of the two scann words
        String lcs = findLCS(stringOne, stringTwo);

        // Print the result to the console
        System.out.println("Longest Common Subsequence: " + lcs);
    }

    public static String findLCS(String stringOne, String stringTwo) {
        // Create a 2D array to store the lengths of common subsequences
        int[][] lengths = new int[stringOne.length() + 1][stringTwo.length() + 1];

        // Build the length matrix
        for (int i = 0; i < stringOne.length(); i++) {
            for (int j = 0; j < stringTwo.length(); j++) {
                // If the current characters match, the length of the common subsequence
                // increases by 1
                if (stringOne.charAt(i) == stringTwo.charAt(j)) {
                    lengths[i + 1][j + 1] = lengths[i][j] + 1;
                } else {
                    // Otherwise, the length of the common subsequence is the maximum of the lengths
                    // of the subsequences without the current character
                    lengths[i + 1][j + 1] = Math.max(lengths[i + 1][j], lengths[i][j + 1]);
                }
            }
        }

        // Create a StringBuilder object to build the LCS string
        StringBuilder lcs = new StringBuilder();

        // Iterate through the length matrix in reverse to build the LCS string
        for (int i = stringOne.length(), j = stringTwo.length(); i != 0 && j != 0;) {
            // If the current cell's value is equal to the value above it, move up
            if (lengths[i][j] == lengths[i - 1][j]) {
                i--;
            }
            // If the current cell's value is equal to the value to the left, move left
            else if (lengths[i][j] == lengths[i][j - 1]) {
                j--;
            }
            // Otherwise, the characters at the current positions match, so append the
            // character to the LCS string and move diagonally up-left
            else {
                assert stringOne.charAt(i - 1) == stringTwo.charAt(j - 1);
                lcs.append(stringOne.charAt(i - 1));
                i--;
                j--;
            }
        }

        // Return the completed LCS string
        return lcs.reverse().toString();
    }
}