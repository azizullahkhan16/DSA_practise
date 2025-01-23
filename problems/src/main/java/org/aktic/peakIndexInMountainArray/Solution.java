package org.aktic.peakIndexInMountainArray;

public class Solution {
    public static int peakIndexInMountainArray(int[] arr) {
        if(arr.length < 3) return -1;
        if(arr.length == 3) return 1;
        int low = 0;
        int high = arr.length-1;

        while (low <= high) {
            int mid = low + (high-low)/2;
            if(mid-1 < 0) low = mid+1;
            else if(mid+1 > arr.length-1) high = mid-1;
            else if(arr[mid-1] < arr[mid] && arr[mid] < arr[mid+1]) {
                low = mid+1;
            }else if(arr[mid-1] > arr[mid] && arr[mid] > arr[mid+1]) {
                high = mid-1;
            }else if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]) {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[] {3,5,3,2,0}));
    }
}
