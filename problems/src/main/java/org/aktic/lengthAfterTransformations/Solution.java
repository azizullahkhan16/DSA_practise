package org.aktic.lengthAfterTransformations;

public class Solution {
    public static int lengthAfterTransformations(String s, int t) {
        final int MOD = 1_000_000_007;
        long[] freq = new long[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int step = 0; step < t; step++) {
            long[] newFreq = new long[26];

            for (int i = 0; i < 26; i++) {
                if (i == 25) { // 'z'
                    newFreq[0] = (newFreq[0] + freq[i]) % MOD;
                    newFreq[1] = (newFreq[1] + freq[i]) % MOD;
                } else {
                    newFreq[i + 1] = (newFreq[i + 1] + freq[i]) % MOD;
                }
            }

            freq = newFreq;
        }

        long total = 0;
        for (long f : freq) {
            total = (total + f) % MOD;
        }

        return (int) total;
    }

    public static void main(String[] args) {
        System.out.println(lengthAfterTransformations("cu", 5));
    }
}
