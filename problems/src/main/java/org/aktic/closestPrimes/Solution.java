package org.aktic.closestPrimes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;

        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

//    public static int[] closestPrimes(int left, int right) {
//        List<Integer> primes = new ArrayList<>();
//
//        for (int i = left; i <= right; i++) {
//            if (isPrime(i)) primes.add(i);
//        }
//        if (primes.size() < 2) return new int[]{-1, -1};
//        if (primes.size() == 2) return new int[]{primes.get(0), primes.get(1)};
//
//        int first = -1;
//        int second = -1;
//        int min = Integer.MAX_VALUE;
//
//        for (int i = 0; i < primes.size() - 1; i++) {
//            if (min > (primes.get(i + 1) - primes.get(i))) {
//                first = primes.get(i);
//                second = primes.get(i + 1);
//                min = second - first;
//            }
//        }
//
//        return new int[]{first, second};
//
//
//    }

    public static int[] closestPrimes(int left, int right) {
        int first = -1;
        int second = -1;
        int prev = -1;

        for (int i = left; i <= right; i++) {
            if (first == -1 || second == -1) {
                if (isPrime(i) && first == -1) {
                    first = i;
                } else if (isPrime(i)) {
                    second = i;
                    prev = second;
                }
            } else {
                if (isPrime(i)) {
                    if (second - first > i - prev) {
                        first = prev;
                        second = i;
                    } else prev = i;
                }
            }
        }

        if (first == -1 || second == -1) return new int[]{-1, -1};
        return new int[]{first, second};
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(closestPrimes(19, 31)));
        System.out.println(isPrime(1879));
    }
}
