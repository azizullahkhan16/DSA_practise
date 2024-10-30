package org.aktic.removeDuplicatesII;

public class Solution {
//    public static int removeDuplicates(int[] nums) {
//        int count = 1;
//        int prev = nums[0];
//        int res = 0;
//
//        for (int i = 1; i < nums.length; i++) {
//            if(nums[i] != prev) {
//                prev = nums[i];
//                count = 1;
//            } else if(nums[i] == prev) {
//                count++;
//                if(count > 2) {
//                    nums[i] = Integer.MIN_VALUE;
//                    res++;
//                }
//            }
//        }
//
//        for (int i = 1; i < nums.length; i++) {
//            int curr = i;
//            while(nums[curr-1] == Integer.MIN_VALUE && nums[curr] != Integer.MIN_VALUE) {
//                int temp = nums[curr];
//                nums[curr] = Integer.MIN_VALUE;
//                nums[curr-1] = temp;
//                curr--;
//            }
//        }
//
//        return nums.length-res;
//    }

    public static int removeDuplicates(int[] nums) {
        int curr = 0;

        for (int i=0; i<nums.length; i++ ) {
            if (curr < 2  ||  nums[i] != nums[curr-2] ) {
                nums[curr] = nums[i];
                curr++;
            }
        }
        return curr;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
}
