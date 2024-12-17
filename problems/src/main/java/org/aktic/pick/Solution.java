package org.aktic.pick;

import java.util.Random;

public class Solution {
    private int[] originalNums;
    public Solution(int[] nums) {
        this.originalNums = nums;
    }

    public int pick(int target) {
        Random rand = new Random();
        while(true) {
            int index = rand.nextInt(originalNums.length);
            if(originalNums[index] == target) {
                return index;
            }
        }
    }
}
