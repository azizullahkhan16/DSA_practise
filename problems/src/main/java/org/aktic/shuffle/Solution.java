package org.aktic.shuffle;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    private int[] originalNums;
    private int[] res;
    public Solution(int[] nums) {
        this.originalNums = nums.clone();
        this.res = nums.clone();
    }

    public int[] reset() {
        return originalNums;
    }

    public int[] shuffle() {
        Random rand = new Random();
        for (int i = 0; i < res.length-1; i++) {
            int index = rand.nextInt(i+1, res.length);
            int temp = res[i];
            res[i] = res[index];
            res[index] = temp;
        }

        return this.res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        Solution solution = new Solution(nums);
        System.out.println(Arrays.toString(solution.shuffle()));
    }
}
