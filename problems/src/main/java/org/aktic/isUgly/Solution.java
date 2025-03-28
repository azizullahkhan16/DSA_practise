package org.aktic.isUgly;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static boolean isUgly(int n) {
        if (n <= 0) return false;

        int[] divisors = {2, 3, 5};
        for (int divisor : divisors) {
            while (n % divisor == 0) {
                n /= divisor;
            }
        }

        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(14));
    }
}
