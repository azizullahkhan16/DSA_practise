package org.aktic.sortPeople;

import java.util.*;

public class Solution {
    public static String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }

        Arrays.sort(heights);
        List<String> res = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            res.add(map.get(heights[i]));
        }

        Collections.reverse(res);


        return res.toArray(new String[0]);


    }


    public static void main(String[] args) {
        String[] names = {"Mary","John","Emma"};
        int[] heights = {180,165,170};
        System.out.println(Arrays.toString(sortPeople(names, heights)));
    }
}
