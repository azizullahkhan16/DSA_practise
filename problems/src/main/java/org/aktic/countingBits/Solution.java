package org.aktic.countingBits;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public static int[] countBits(int n) {
        int[] res = new int[n + 1];

        int ones = 0;
        int temp = 0;
        int remainder = 0;

        for (int i = 0; i <= 5; i++) {
            temp = i;
            while(temp != 0) {
                remainder = temp % 2;
                if(remainder == 1) ones++;
                temp /= 2;
            }
            res[i] = ones;
            ones = 0;
        }



        return res;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }


}
