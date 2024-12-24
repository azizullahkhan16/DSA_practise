package org.aktic.thirdMax;

import java.util.*;

public class Solution {
    public static int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;

        for(int num: nums) {
            if(((max1 != null) && (max1 == num))
                    || ((max2 != null) && (max2 == num))
                    || ((max3 != null) && (max3 == num))) {
                continue;
            }

            if(max1 == null || max1 < num) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            }else if(max2 == null || max2 < num) {
                max3 = max2;
                max2 = num;
            }else if(max3 == null || max3 < num) {
                max3 = num;
            }
        }

        return max3 == null ? max1 : max3;
    }


    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{3, 2, 1}));
    }
}
