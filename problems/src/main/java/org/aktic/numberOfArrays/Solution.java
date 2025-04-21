package org.aktic.numberOfArrays;

public class Solution {
//    public static int numberOfArrays(int[] differences, int lower, int upper) {
//        int count = 0;
//        for (int i = lower; i <= upper; i++) {
//            int size = 0;
//            int index = 0;
//            int prev = i;
//
//            while (index < differences.length) {
//                int sum = prev + differences[index];
//                if (lower <= sum && sum <= upper) {
//                    size++;
//                    index++;
//                    prev = sum;
//                } else break;
//            }
//
//            if (size == differences.length) count++;
//        }
//
//        return count;
//    }

    public static int numberOfArrays(int[] differences, int lower, int upper) {
        long minPrefixSum = 0, maxPrefixSum = 0, currentSum = 0;

        for (int diff : differences) {
            currentSum += diff;
            minPrefixSum = Math.min(minPrefixSum, currentSum);
            maxPrefixSum = Math.max(maxPrefixSum, currentSum);
        }

        long lowerBound = lower - minPrefixSum;
        long upperBound = upper - maxPrefixSum;

        return (int) Math.max(0, upperBound - lowerBound + 1);
    }

    public static void main(String[] args) {
        System.out.println(numberOfArrays(new int[]{3, -4, 5, 1, -2}, -4, 5));
    }
}
