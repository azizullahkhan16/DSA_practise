package org.aktic.sortColors;

public class Solution {
//    public static void sortColors(int[] nums) {
//        int zeros = 0;
//        int ones = 0;
//
//        for (int num : nums) {
//            if (num == 0) zeros++;
//            else if (num == 1) ones++;
//        }
//
//
//        for (int i = 0; i < nums.length; i++) {
//            if (zeros != 0) {
//                nums[i] = 0;
//                zeros--;
//            } else if (ones != 0) {
//                nums[i] = 1;
//                ones--;
//            } else nums[i] = 2;
//        }
//    }

    public static void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int index = 0;

        while (index <= right) {
            if (nums[index] == 0) {
                int temp = nums[left];
                nums[left] = nums[index];
                nums[index] = temp;

                left++;
                index++;
            } else if (nums[index] == 2) {
                int temp = nums[right];
                nums[right] = nums[index];
                nums[index] = temp;

                right--;
                if (temp == 1) index++;
            } else index++;
        }
    }

    public static void main(String[] args) {
        sortColors(new int[]{1, 2, 0});
    }
}
