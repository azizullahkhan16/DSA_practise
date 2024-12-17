package org.aktic.FinalPracticeDAA.Question11;

import java.util.*;

public class Solution {
    public static int findTarget(List<Integer> nums) {
        Random random = new Random();
        int n = nums.size();
        int mid = n / 2;

        while (true) {
            int randomIndex = random.nextInt(n);
            int candidate = nums.get(randomIndex);

            int countGreater = 0;
            for (int num : nums) {
                if (num > candidate) {
                    countGreater++;
                }
            }

            if (countGreater < mid) {
                return candidate;
            }
        }
    }

    public static void main(String[] args) {
        // 1, 2, 3, 4, 7, 8, 9
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(7);
        list.add(2);
        list.add(4);
        list.add(8);
        list.add(9);
        list.add(1);
        System.out.println(findTarget(list));
    }
}
