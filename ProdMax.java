package tools;

import java.util.*;

public class ProdMax {

    public static void main(String[] args) {
        var input = new Scanner(System.in);

        System.out.print("Please enter the array size:");
        int size = input.nextInt();
        int[] array = new int[size];
        System.out.print("Please enter the array Values:");
        for (int i = 0; i < size; i++)
            array[i] = input.nextInt();
        int[] maxProductPair = findMaxProductPair(array);
        System.out.println(
                "Pair of numbers with the maximum product is: " + maxProductPair[0] + " and " + maxProductPair[1]);
        System.out.println("Their product is: " + (maxProductPair[0] * maxProductPair[1]));
    }

    public static int[] findMaxProductPair(int[] number) {
        int maxProduct = Integer.MIN_VALUE;
        int[] maxProductPair = new int[2];

        for (int i = 0; i < number.length - 1; i++) {
            for (int j = i + 1; j < number.length; j++) {
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