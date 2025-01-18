package org.aktic.find132pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static boolean find132pattern(int[] nums) {
        if(nums.length < 3) return false;

        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for(int i = 1; i < nums.length; i++) {
            if(list.size() == 1 && list.get(0) < nums[i]) {
                list.add(nums[i]);
            }else if(list.size() == 1 && list.get(0) > nums[i]) {
                list.remove(0);
                list.add(nums[i]);
            }else if(list.size() == 2 && list.get(1) < nums[i]) {
                list.remove(1);
                list.add(nums[i]);
            }else if(list.size() == 2 && list.get(1) > nums[i]) {
                if(list.get(0) < nums[i]) {
                    return true;
                }else {
                    list.clear();
                    list.add(nums[i]);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(find132pattern(new int[] {1,0,1,-4,-3}));
    }
}
