package org.aktic.kidsWithCandies;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        List<Boolean> result = new ArrayList<Boolean>();

        for (int i = 0; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }

        for (int i = 0; i < candies.length; i++) {
            if(extraCandies+candies[i] >= max) result.add(true);
            else result.add(false);
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(kidsWithCandies(new int[]{2,3,5,1,3}, 3));
    }
}
