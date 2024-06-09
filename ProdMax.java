package tools;

import java.util.*;

public class ProdMax {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        var input = new Scanner(System.in);

        // Prompt the user to enter the array size
        System.out.print("Please enter the array size:");
        int size = input.nextInt();

        // Create an array of the specified size
        int[] array = new int[size];

        // Prompt the user to enter the array values
        System.out.print("Please enter the array Values:");
        for (int i = 0; i < size; i++)
            array[i] = input.nextInt();

        // Find the pair of numbers with the maximum product
        int[] maxProductPair = findMaxProductPair(array);

        // Print the result
        System.out.println(
                "Pair of numbers with the maximum product is: " + maxProductPair[0] + " and " + maxProductPair[1]);
        System.out.println("Their product is: " + (maxProductPair[0] * maxProductPair[1]));
    }

    /**
     * Finds the pair of numbers with the maximum product in the given array.
     * 
     * @param number the input array
     * @return an array containing the pair of numbers with the maximum product
     */
    public static int[] findMaxProductPair(int[] number) {
        // Initialize the maximum product and the corresponding pair
        int maxProduct = Integer.MIN_VALUE;
        int[] maxProductPair = new int[2];

        // Iterate through the array to find the maximum product pair
        for (int i = 0; i < number.length - 1; i++) {
            for (int j = i + 1; j < number.length; j++) {
                // Check if the product of the current pair is greater than the maximum product
                if (number[i] * number[j] > maxProduct) {
                    maxProduct = number[i] * number[j];
                    maxProductPair[0] = number[i];
                    maxProductPair[1] = number[j];
                }
            }
        }
        return maxProductPair;
    }
}