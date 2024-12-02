package org.aktic.searchMatrixI;

public class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;       // Number of rows
        int n = matrix[0].length;    // Number of columns

        int left = 0, right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midElement = matrix[mid / n][mid % n];

            if (midElement == target) {
                return true;
            } else if (midElement < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }


    public static boolean binarySearch(int[] vector, int target) {
        int low = 0;
        int high = vector.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (vector[mid] == target) {
                return true;
            }else if(target < vector[mid]){
                high = mid - 1;
            }else {
                low = mid + 1;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
    }
}
