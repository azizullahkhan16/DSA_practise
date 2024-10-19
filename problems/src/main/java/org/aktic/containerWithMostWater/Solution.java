package org.aktic.containerWithMostWater;

public class Solution {

    public static int maxArea(int[] height) {
        int maxArea = 0;

        int left = 0, right = height.length - 1;
        int h, w;

        while (left < right) {
            h = Math.min(height[left], height[right]);
            w = right - left;

            maxArea = Math.max(maxArea, h * w);

            if(h == height[left]) left++;
            else right--;
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,1}));
    }
}
