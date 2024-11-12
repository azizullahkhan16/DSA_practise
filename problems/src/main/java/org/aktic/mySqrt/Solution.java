package org.aktic.mySqrt;

public class Solution {
    public static int mySqrt(int n) {
        if (n < 2) {
            return n;
        }

        int low = 1;
        int high = n;
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long square = (long) mid * mid;

            if (square == n) {
                return mid;
            } else if (square < n) {
                low = mid + 1;
                result = mid;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }
}
