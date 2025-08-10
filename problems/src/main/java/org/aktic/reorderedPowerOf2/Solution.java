package org.aktic.reorderedPowerOf2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static boolean reorderedPowerOf2(int n) {
        int[] targetCount = digitCount(n);

        for (int i = 1; i <= 1_000_000_000; i <<= 1) {
            if (Arrays.equals(targetCount, digitCount(i))) {
                return true;
            }
        }
        return false;
    }

    private static int[] digitCount(int num) {
        int[] count = new int[10];
        while (num > 0) {
            count[num % 10]++;
            num /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(10));
    }
}
