package org.aktic.threeConsecutiveOdds;

public class Solution {
    public static boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length < 3) return false;

        int left = 0;
        int mid = 1;
        int right = 2;

        while (right < arr.length) {
            if (arr[left] % 2 != 0 && arr[mid] % 2 != 0 && arr[right] % 2 != 0) return true;
            left++;
            mid++;
            right++;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(threeConsecutiveOdds(new int[]{1, 2, 34, 3, 4, 5, 7, 23, 12}));
    }
}
