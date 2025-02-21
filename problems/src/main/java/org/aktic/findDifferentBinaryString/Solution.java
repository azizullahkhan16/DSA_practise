package org.aktic.findDifferentBinaryString;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static String findDifferentBinaryString(String[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(Integer.parseInt(nums[i], 2));
        }

        int n = nums[0].length();
        double limit = Math.pow(2, n);

        for (int i = 0; i < limit; i++) {
            if (!set.contains(i)) {
                return decimalToBinary(i, n);
            }
        }

        return "0";

    }

    public static String decimalToBinary(int decimal, int length) {
        String binary = Integer.toBinaryString(decimal);
        return String.format("%" + length + "s", binary).replace(' ', '0'); // Pad with leading zeros
    }

    public static int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }

    public static void main(String[] args) {
        System.out.println(findDifferentBinaryString(new String[]{"00", "01"}));
    }
}
