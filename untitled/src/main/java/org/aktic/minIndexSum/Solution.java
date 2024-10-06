package org.aktic.minIndexSum;

import java.util.*;

public class Solution {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        List<String> res = new ArrayList<String>();

        Map<String, Integer> map = new HashMap<String, Integer>();

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < list2.length && i <= min; i++) {
            if(map.containsKey(list2[i])) {
                int temp = map.get(list2[i])+i;
                if (temp < min) {
                    res.clear();
                    res.add(list2[i]);
                    min = temp;
                } else if (temp == min)
                    res.add(list2[i]);
            }
        }
        return res.toArray(new String[res.size()]);


    }

    public static void main(String[] args) {
        String[] list1 = {"happy","sad","good"};
        String[] list2 = {"sad","happy","good"};
        System.out.println(Arrays.toString(findRestaurant(list1, list2)));
    }
}
