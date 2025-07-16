package org.aktic.maximumLength;

public class Solution {
    public static int maximumLength(int[] nums) {
        int evenOdd = 0;
        int oddEven = 0;
        int evenEven = 0;
        int oddOdd = 0;

        boolean isEven = false;
        boolean isOdd = false;

        for (int num : nums) {
            // even-even check
            if (num % 2 == 0 && !isEven) {
                evenOdd++;
                isEven = true;
            } else if (num % 2 == 1 && isEven) {
                evenOdd++;
                isEven = false;
            }

            // odd-even check
            if (num % 2 == 1 && !isOdd) {
                oddEven++;
                isOdd = true;
            } else if (num % 2 == 0 && isOdd) {
                oddEven++;
                isOdd = false;
            }

            // odd-odd and even-even check
            if (num % 2 == 0) evenEven++;
            else oddOdd++;
        }

        return Math.max(oddEven, Math.max(evenOdd, Math.max(oddOdd, evenEven)));
    }

    public static void main(String[] args) {
        System.out.println(maximumLength(new int[]{1, 2, 1, 1, 2, 1, 2}));
    }
}
