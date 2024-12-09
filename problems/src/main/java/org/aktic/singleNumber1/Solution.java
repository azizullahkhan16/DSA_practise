package org.aktic.singleNumber1;

public class Solution {
    public static int singleNumber(int[] nums) {
        int ones = 0, twos = 0;

        for (int num : nums) {
            ones = (ones ^ num) & ~twos;

            twos = (twos ^ num) & ~ones;
        }

        return ones;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{3, 4, 4, 4, 2, 2, 7, 7, 7, 2}));
    }
}
