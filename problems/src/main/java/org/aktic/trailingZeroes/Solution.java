package org.aktic.trailingZeroes;

import java.math.BigInteger;

public class Solution {
    public static int trailingZeroes(int n) {
        int count = 0;
        int divisor = 5;
        while (n / divisor > 0) {
            count += n / divisor;
            divisor *= 5;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(7756));
    }
}
