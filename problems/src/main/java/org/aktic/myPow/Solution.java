package org.aktic.myPow;

public class Solution {
    public static double myPow(double x, int n) {
        if (n == 0) return 1;

        long N = n; // Use long to avoid overflow for Integer.MIN_VALUE
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1;
        while (N > 0) {
            if ((N % 2) == 1) { // If N is odd
                result *= x;
            }
            x *= x; // Square the base
            N /= 2; // Divide the exponent by 2
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2,-2));
    }
}
