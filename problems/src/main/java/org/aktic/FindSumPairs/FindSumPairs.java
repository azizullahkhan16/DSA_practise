package org.aktic.FindSumPairs;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindSumPairs {
    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> map;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;

        this.map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], map.getOrDefault(nums2[i], 0) + 1);
        }
    }

    public void add(int index, int val) {
        map.put(nums2[index], map.get(nums2[index]) - 1);
        nums2[index] += val;
        map.put(nums2[index], map.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int count = 0;

        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(tot - nums1[i])) {
                count += map.get(tot - nums1[i]);
            }
        }

        return count;
    }

}