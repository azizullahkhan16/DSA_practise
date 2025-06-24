package org.aktic.findKDistantIndices;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        List<Integer> keyIndices = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) keyIndices.add(i);
        }

        for (int i = 0; i < keyIndices.size(); i++) {
            int startIndex = Math.max(keyIndices.get(i) - k, 0);
            int endIndex = keyIndices.get(i) + k < nums.length ? keyIndices.get(i) + k : nums.length - 1;


            for (int j = startIndex; j <= endIndex; j++) {
                if (res.isEmpty() || j > res.getLast()) {
                    res.add(j);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(findKDistantIndices(new int[]{3, 4, 9, 1, 3, 9, 5}, 9, 1));
    }
}
