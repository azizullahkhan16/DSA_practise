package org.aktic.mergeArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int left = 0;
        int right = 0;
        List<List<Integer>> res = new ArrayList<>();
        int index = 0;

        while (left < nums1.length && right < nums2.length) {
            List<Integer> temp = new ArrayList<>();
            if (nums1[left][0] < nums2[right][0]) {
                temp.add(nums1[left][0]);
                temp.add(nums1[left][1]);
                left++;
            } else if (nums1[left][0] > nums2[right][0]) {
                temp.add(nums2[right][0]);
                temp.add(nums2[right][1]);
                right++;
            } else {
                temp.add(nums1[left][0]);
                temp.add(nums1[left][1] + nums2[right][1]);
                left++;
                right++;
            }

            res.add(temp);
        }

        while (left < nums1.length) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums1[left][0]);
            temp.add(nums1[left][1]);
            res.add(temp);
            left++;
        }

        while (right < nums2.length) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums2[right][0]);
            temp.add(nums2[right][1]);
            res.add(temp);
            right++;
        }

        return res.stream().map(l -> l.stream().mapToInt(i -> i).toArray()).toArray(int[][]::new);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(mergeArrays(new int[][]{{2, 4}, {3, 6}, {5, 5}}, new int[][]{{1, 3}, {4, 3}})));
    }
}
