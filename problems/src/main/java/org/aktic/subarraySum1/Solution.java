package org.aktic.subarraySum1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int left = 0;
        int right = 0;
        int sum = 0;
        ArrayList<Integer> res = new ArrayList<>();

        for (; right < arr.length; right++) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }
            if (sum == target) {
                res.add(++left);
                res.add(++right);
                return res;
            }
        }

        res.add(-1);
        return res;

    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 2, 3, 7, 5}, 12));
    }
}
