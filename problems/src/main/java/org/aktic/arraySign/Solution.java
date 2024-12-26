package org.aktic.arraySign;

public class Solution {
    public static int arraySign(int[] nums) {
        int sign = 1;

        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                sign *= -1;
            }
        }

        return sign;
    }

    public static void main(String[] args) {
        System.out.println(arraySign(new int[]{41,65,14,80,20,10,55,58,24,56,28,86,96,10,3,84,4,41,13,32,42,43,83,78,82,70,15,-41}));
    }
}
