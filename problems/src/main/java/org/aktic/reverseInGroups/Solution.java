package org.aktic.reverseInGroups;

public class Solution {
    public static void reverseInGroups(int[] arr, int k) {
        if (k >= arr.length) {
            reverseArrayInRange(arr, 0, arr.length - 1);
        } else {
            for (int i = 0; i < arr.length; i += k) {
                reverseArrayInRange(arr, i, Math.min(i + k - 1, arr.length - 1));
            }

        }


    }

    public static void reverseArrayInRange(int[] arr, int left, int right) {
        int forward = (right - left + 1) / 2;

        for (int i = left; i < left + forward; i++) {
            int temp = arr[i];
            arr[i] = arr[right];
            arr[right] = temp;
            right--;
        }
    }

    public static void main(String[] args) {
        reverseInGroups(new int[]{5, 6, 8, 9}, 5);
    }
}
