package org.aktic.check;

public class Solution {
    public static boolean check(int[] nums) {
        int min = Integer.MAX_VALUE;
        int minPos = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                if (i != 0 && nums[i] == nums[i - 1]) continue;
                min = nums[i];
                minPos = i;
            }
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int prev = (i + minPos) % nums.length;
            int next = (i + 1 + minPos) % nums.length;
            if (nums[prev] > nums[next]) return false;
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(check(new int[]{6, 10, 6}));
    }
}
