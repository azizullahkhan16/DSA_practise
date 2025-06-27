package org.aktic.findLargest1;

public class Solution {
    static String findLargest(int n, int s) {
        // Edge case: if sum is 0 and n is 1, return "0"; else no valid number
        if (s == 0) {
            return n == 1 ? "0" : "-1";
        }

        // If sum is greater than the maximum possible sum with n digits (9 * n), return -1
        if (s > 9 * n) return "-1";

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            // Choose the maximum digit that fits in the remaining sum
            int digit = Math.min(9, s);
            result.append(digit);
            s -= digit;
        }

        return result.toString();
    }


    public static void main(String[] args) {
        System.out.println(findLargest(2, 9));
    }

}
