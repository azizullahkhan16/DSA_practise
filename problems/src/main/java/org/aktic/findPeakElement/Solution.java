package org.aktic.findPeakElement;


public class Solution {
    public static int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        if(nums.length == 2) return nums[0] == Math.max(nums[0], nums[1]) ? 0 : 1;

        int low = 0;
        int high = nums.length-1;

        while (low <= high) {
            int mid = low + (high-low)/2;

            if(mid-1 < 0) low = mid+1;
            else if(mid+1 > nums.length-1) high = mid-1;
            else if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                return mid;
            }else if(nums[mid] < nums[mid+1]) {
                low = mid+1;
            }else if(nums[mid] < nums[mid-1]) {
                high = mid-1;
            }
        }

        return nums[0] > nums[1] ? 0 : nums[nums.length-1] > nums[nums.length-2] ? nums.length-1 : -1;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[] {3,4,3,2,1}));
    }
}
