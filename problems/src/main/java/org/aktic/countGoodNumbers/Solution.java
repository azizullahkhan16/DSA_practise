package org.aktic.countGoodNumbers;

public class Solution {
    static final int MOD = 1_000_000_007;

    public static int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2; // number of even indices
        long oddCount = n / 2;        // number of odd indices

        long evenPart = modPow(5, evenCount, MOD);
        long oddPart = modPow(4, oddCount, MOD);

        return (int) ((evenPart * oddPart) % MOD);
    }

    // Fast modular exponentiation
    private static long modPow(long base, long exp, int mod) {
        long result = 1;
        base %= mod;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(countGoodNumbers(1));
    }
}
