package org.aktic.countHillValley;

public class Solution {
    public static int countHillValley(int[] nums) {
        if (nums.length < 3) return 0;

        int res = 0;
        int prev = nums[0];
        int curr;


        for (int i = 1; i < nums.length - 1; i++) {
            curr = nums[i];
            int index = i + 1;

            while (index < nums.length && nums[index] == curr) {
                index++;
            }

            if (index >= nums.length) break;

            int next = nums[index];

            if ((curr > prev && curr > next) || (curr < prev && curr < next)) {
                res++;
            }

            prev = curr;
            i = index - 1;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(countHillValley(new int[]{6, 6, 5, 5, 4, 1}));
    }
}
