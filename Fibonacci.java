
package tools;

import java.util.*;

// Class to generate Fibonacci series
public class Fibonacci {

    /**
     * Recursive function to calculate the nth Fibonacci number
     */
    public static int fibonacciRecursion(int count) {
        // Base case: Fibonacci of 0 is 0
        if (count == 0) {
            return 0;
        }
        // Base case: Fibonacci of 1 and 2 is 1
        if (count == 1 || count == 2) {
            return 1;
        }
        // Recursive case: Fibonacci of n is the sum of Fibonacci of n-1 and n-2
        return fibonacciRecursion(count - 1) + fibonacciRecursion(count - 2);
    }

    public static void main(String args[]) {
        // Create a scanner to read user input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of Fibonacci numbers to generate: ");
        int fib_len = input.nextInt();

        System.out.print("Fibonacci Series of " + fib_len + " numbers is: \n");
        // Generate and print the Fibonacci series
        for (int i = 0; i < fib_len; i++) {
            System.out.print(fibonacciRecursion(i) + " ");
        }
    }
}