package org.aktic.mergeSortedArray;

public class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] a = new int[m];

        for (int i = 0; i < a.length; i++) {
            a[i] = nums1[i];
        }

        int left = 0;
        int right = 0;
        int res = 0;

        while (left < a.length && right < n) {
            if (a[left] < nums2[right]) {
                nums1[res++] = a[left++];
            } else nums1[res++] = nums2[right++];
        }

        for (; left < a.length; left++) {
            nums1[res++] = a[left];
        }

        for (; right < n; right++) {
            nums1[res++] = nums2[right];
        }

    }
    public static void main(String[] args) {
        int[] nums1 = {4,0,0,0,0,0};
        int[] nums2 = {1,2,3,5,6};
       merge(nums1, 1, nums2, 5);
    }
}
