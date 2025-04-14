package org.aktic.countGoodTriplets;

public class Solution {
    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (isValid(arr[i], arr[j], arr[k], a, b, c)) count++;
                }
            }
        }

        return count;
    }

    private static boolean isValid(int num1, int num2, int num3, int a, int b, int c) {
        return Math.abs(num1 - num2) <= a && Math.abs(num2 - num3) <= b && Math.abs(num1 - num3) <= c;
    }

    public static void main(String[] args) {

    }
}
