package org.aktic.findTheDfferenceOfTwoArrays;

import java.util.*;

public class Solution {

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }

        for(Integer i : set1) {
            if(!set2.contains(i)) list1.add(i);
        }

        for(Integer i : set2) {
            if(!set1.contains(i)) list2.add(i);
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(list1);
        res.add(list2);

        return res;

    }

    public static void main(String[] args) {
        System.out.println(findDifference(new int[]{1,2,3,3}, new int[]{1,1,2,2}));
    }
}
