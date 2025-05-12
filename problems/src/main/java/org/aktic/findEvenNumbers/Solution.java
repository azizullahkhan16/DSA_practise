package org.aktic.findEvenNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int[] findEvenNumbers(int[] digits) {
        int[] count = new int[10];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < digits.length; i++) {
            count[digits[i]]++;
        }

        for (int i = 100; i <= 999; i += 2) {
            int[] temp = new int[10];
            String num = String.valueOf(i);
            for (int j = 0; j < num.length(); j++) {
                temp[Character.getNumericValue(num.charAt(j))]++;
            }

            boolean isPresent = true;
            for (int j = 0; j < count.length; j++) {
                if (temp[j] == 0) continue;
                if (count[j] >= temp[j]) {
                    isPresent = false;
                    break;
                }
            }

            if (isPresent) res.add(i);
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findEvenNumbers(new int[]{2, 1, 3, 0})));
    }
}
