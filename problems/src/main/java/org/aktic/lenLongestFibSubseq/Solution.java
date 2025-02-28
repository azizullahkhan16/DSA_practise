package org.aktic.lenLongestFibSubseq;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int lenLongestFibSubseq(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int res = 0;

        for (int num : arr) {
            set.add(num);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int prev = arr[i];
                int curr = arr[j];
                int next = prev + curr;

                int length = 2;
                while (set.contains(next)) {
                    length++;
                    prev = curr;
                    curr = next;
                    next = prev + curr;
                    res = Math.max(res, length);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }
}
