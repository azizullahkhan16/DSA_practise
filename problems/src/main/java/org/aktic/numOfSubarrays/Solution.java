package org.aktic.numOfSubarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static int numOfSubarrays(int[] arr) {
        int oddCount = 0;
        int evenCount = 0;
        int prefixSum = 0;
        int result = 0;
        int MOD = 1_000_000_007;

        for (int num : arr) {
            prefixSum += num;
            if (prefixSum % 2 == 0) {
                result = (result + oddCount) % MOD;
                evenCount++;
            } else {
                result = (result + evenCount) % MOD;
                oddCount++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(numOfSubarrays(new int[]{1, 3, 5}));
    }
}
