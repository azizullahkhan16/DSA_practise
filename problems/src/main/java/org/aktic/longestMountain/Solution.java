package org.aktic.longestMountain;

public class Solution {
    public static int longestMountain(int[] arr) {
        int n = arr.length;
        int res = 0;
        int i = 1;

        while (i < n - 1) {

            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                int right = i + 1;

                while (left > 0 && arr[left - 1] < arr[left]) {
                    left--;
                }

                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                res = Math.max(res, right - left + 1);

                i = right;
            } else {
                i++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}));
    }
}
