package org.aktic.productQueries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    private static final long MOD = 1_000_000_007;

    public static int[] productQueries(int n, int[][] queries) {
        // Step 1: Extract powers of 2 from binary representation of n
        List<Long> powers = new ArrayList<>();
        for (int i = 0; i < 31; i++) { // up to 2^30 fits in int
            if ((n & (1 << i)) != 0) {
                powers.add(1L << i);
            }
        }
        Collections.sort(powers);

        // Step 2: Prefix product array
        long[] prefix = new long[powers.size()];
        prefix[0] = powers.get(0) % MOD;
        for (int i = 1; i < powers.size(); i++) {
            prefix[i] = (prefix[i - 1] * powers.get(i)) % MOD;
        }

        // Step 3: Answer queries
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            if (l == 0) {
                res[i] = (int) prefix[r];
            } else {
                long val = (prefix[r] * modInverse(prefix[l - 1])) % MOD;
                res[i] = (int) val;
            }
        }
        return res;
    }

    // Modular inverse using Fermat's little theorem
    private static long modInverse(long a) {
        return pow(a, MOD - 2);
    }

    // Fast exponentiation
    private static long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productQueries(15, new int[][]{{0, 1}, {2, 2}, {0, 3}})));
    }
}
