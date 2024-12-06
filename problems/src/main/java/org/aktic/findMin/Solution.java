package org.aktic.findMin;

public class Solution {
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            }else {
                right = mid;
            }

        }

        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{5,1,2,3,4}));
    }
}
