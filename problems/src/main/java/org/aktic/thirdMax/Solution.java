package org.aktic.thirdMax;

import java.util.*;

public class Solution {
    public static int thirdMax(int[] nums) {
        TreeSet<Integer> priorityQueue = new TreeSet<>(Comparator.reverseOrder());

        for (int num : nums) {
            priorityQueue.add(num);
        }

        if (priorityQueue.size() < 3) {
            return priorityQueue.first();
        }

        priorityQueue.pollFirst();
        priorityQueue.pollFirst();

        return priorityQueue.pollFirst();
    }


    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{1,2,3,4,5,6,7,8,9}));
    }
}
