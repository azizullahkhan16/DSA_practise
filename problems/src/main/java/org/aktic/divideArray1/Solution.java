package org.aktic.divideArray1;

import java.util.Arrays;

public class Solution {
    public static int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);

        int[][] res = new int[nums.length / 3][3];
        res[0][0] = nums[0];

        int x = 0, y = 1;
        for (int i = 1; i < nums.length; i++) {
            res[x][y] = nums[i];
            y++;

            if (y == 3) {
                if (res[x][2] - res[x][0] > k) return new int[0][0];
                y = 0;
                x++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(divideArray(new int[]{2, 4, 2, 2, 5, 2}, 2)));
    }
}
