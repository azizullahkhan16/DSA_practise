package org.aktic.searchMatrix;

public class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == target) {
                return true;
            }else if(matrix[i][0] > target) {
                break;
            } else if(matrix[i][matrix.length-1] < target) {
                continue;
            }
            if(binarySearch(matrix[i], target)) {
                return true;
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


}
