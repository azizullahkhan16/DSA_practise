package org.aktic.countLargestGroup;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for (int i = 1; i <= n; i++) {
            int temp = sumOfDigits(i);
            int existing = map.getOrDefault(temp, 0);
            map.put(temp, existing + 1);
            max = Math.max(max, existing + 1);
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max == entry.getValue()) {
                count++;
            }
        }

        return count;
    }

    public static int sumOfDigits(int n) {
        String num = String.valueOf(n);
        int sum = 0;
        for (char c : num.toCharArray()) {
            sum += Character.getNumericValue(c);
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(countLargestGroup(13));
    }
}
