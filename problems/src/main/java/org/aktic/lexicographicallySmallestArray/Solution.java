package org.aktic.lexicographicallySmallestArray;

import java.util.*;

public class Solution {
    public static int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] sortednums = nums.clone();
        Arrays.sort(sortednums);

        List<Queue<Integer>> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        list.add(new LinkedList<>());
        int index = 0;
        list.get(0).add(sortednums[0]);
        map.put(sortednums[0], index);

        for (int i = 1; i < sortednums.length; i++) {
            if(Math.abs(sortednums[i-1]-sortednums[i]) <= limit) {
                list.get(index).add(sortednums[i]);
            }else {
                index++;
                list.add(new LinkedList<>());
                list.get(index).add(sortednums[i]);
            }
            map.put(sortednums[i], index);
        }

        for (int i = 0; i < nums.length; i++) {
            int tempIndex = map.get(nums[i]);
            nums[i] = list.get(tempIndex).poll();
        }

        return nums;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(lexicographicallySmallestArray(new int[]{5,100,44,45,16,30,14,65,83,64}, 15)));
    }
}
