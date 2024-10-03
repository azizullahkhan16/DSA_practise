package org.aktic.moveZeroes;

public class Solution {
//    public static void moveZeroes(int[] nums) {
//
//        int temp = 0;
//
//        for (int i = nums.length-1; i >= 0 ; i--) {
//            if(nums[i] == 0) {
//                temp = i;
//
//                while (temp < nums.length-1 && nums[temp] != 0) {
//                    nums[temp] = nums[temp+1];
//                    nums[temp+1] = 0;
//                    temp++;
//                }
//            }
//        }
//
//    }

    public static void moveZeroes(int[] nums) {
        int numZeroes = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                numZeroes++;
            }
            else if (numZeroes > 0) {
                int t = nums[i];
                nums[i]=0;
                nums[i-numZeroes]=t;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
    }


}
