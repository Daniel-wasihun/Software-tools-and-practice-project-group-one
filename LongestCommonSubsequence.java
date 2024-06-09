package tools;

import java.util.*;
import java.util.Scanner;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first Word:");
        String stringOne = input.nextLine();
        System.out.print("Enter the second Word:");
        String stringTwo = input.nextLine();

        String lcs = findLCS(stringOne, stringTwo);
        System.out.println("Longest Common Subsequence: " + lcs);
    }

    public static String findLCS(String stringOne, String stringTwo) {
        int[][] lengths = new int[stringOne.length() + 1][stringTwo.length() + 1];

        // Build the length matrix
        for (int i = 0; i < stringOne.length(); i++) {
            for (int j = 0; j < stringTwo.length(); j++) {
                if (stringOne.charAt(i) == stringTwo.charAt(j)) {
                    lengths[i + 1][j + 1] = lengths[i][j] + 1;
                } else {
                    lengths[i + 1][j + 1] = Math.max(lengths[i + 1][j], lengths[i][j + 1]);
                }
            }
        }

        // Build the LCS string
        StringBuilder lcs = new StringBuilder();
        for (int i = stringOne.length(), j = stringTwo.length(); i != 0 && j != 0;) {
            if (lengths[i][j] == lengths[i - 1][j]) {
                i--;
            } else if (lengths[i][j] == lengths[i][j - 1]) {
                j--;
            } else {
                assert stringOne.charAt(i - 1) == stringTwo.charAt(j - 1);
                lcs.append(stringOne.charAt(i - 1));
                i--;
                j--;
            }
        }

        return lcs.reverse().toString();
    }
}
