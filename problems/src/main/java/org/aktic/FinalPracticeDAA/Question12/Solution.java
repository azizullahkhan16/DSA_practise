package org.aktic.FinalPracticeDAA.Question12;

import java.util.Random;

public class Solution {
    private static int findIndex(int[] nums, int target) {
        Random random = new Random();
        while(true) {
            int index = random.nextInt(nums.length);
            if(nums[index] == target) return index;
        }
    }

    public static void main(String[] args) {
    }
}
