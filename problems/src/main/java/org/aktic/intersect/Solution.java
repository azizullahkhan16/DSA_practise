package org.aktic.intersect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> same = new ArrayList<Integer>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int left = 0, right = 0;

        while (left < nums1.length && right < nums2.length) {
            if (nums1[left] == nums2[right]) {
                same.add(nums1[left]);
                left++;
                right++;
            }else if(nums1[left] > nums2[right]){
                right++;
            } else {
                left++;
            }
        }

        int[] res = new int[same.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = same.get(i);
        }

        return res;
    }


    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
}
