package org.aktic.KthSmallestInSortedArrays;

public class Solution {
    public static int findKthElement(int[] a, int[] b, int k) {
        int m = a.length;
        int n = b.length;

        // Ensure that the smaller array is the first one
        if (m > n) {
            return findKthElement(b, a, k);
        }

        // If one array is empty, the k-th smallest element is from the other array
        if (m == 0) {
            return b[k - 1];
        }

        // Base case: when k == 1, the smallest element is the minimum of the first elements
        if (k == 1) {
            return Math.min(a[0], b[0]);
        }

        // Divide k into two parts
        int i = Math.min(m, k / 2);  // Number of elements to consider from array a
        int j = Math.min(n, k / 2);  // Number of elements to consider from array b

        // Compare a[i-1] and b[j-1], and eliminate part of the search space
        if (a[i - 1] < b[j - 1]) {
            // Eliminate the first i elements of array a and search for the (k-i)-th element
            int[] newA = new int[m - i];
            System.arraycopy(a, i, newA, 0, m - i);
            return findKthElement(newA, b, k - i);
        } else {
            // Eliminate the first j elements of array b and search for the (k-j)-th element
            int[] newB = new int[n - j];
            System.arraycopy(b, j, newB, 0, n - j);
            return findKthElement(a, newB, k - j);
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 8, 9, 15};
        int[] B = {7, 11, 18, 19, 21, 25};

        int k = 10;
        int result = findKthElement(A, B, k);
        System.out.println("The " + k + "-th smallest element is: " + result);
    }
}
