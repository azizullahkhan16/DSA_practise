package org.aktic.isPowerOfTwo;

public class Solution {
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        while (Math.abs(n) > 1) {
            if (n % 2 != 0) return false;
            n /= 2;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(-16));
    }
}
