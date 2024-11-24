package org.aktic.search;

public class Solution {
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[left] <= nums[mid]) {
                if(nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else {
                if(nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
            if(nums[mid] == target) {
                return mid;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        System.out.println(search(new int[] {7,8,1,2,3,4,5,6}, 8));
    }
}
