package tools;

import java.util.*;

public class Fibonacci {

    public static int fibonacciRecursion(int count) {
        if (count == 0) {
            return 0;
        } // Fibonacci of 0 is 0

        if (count == 1 || count == 2) {
            return 1;
        }
        return fibonacciRecursion(count - 1) + fibonacciRecursion(count - 2);
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number:");
        int fib_len = input.nextInt();

        System.out.print("Fibonacci Series of " + fib_len + " numbers is: \n");
        for (int i = 0; i < fib_len; i++) {
            System.out.print(fibonacciRecursion(i) + " ");
        }

    }
}