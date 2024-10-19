package org.aktic.firstBadVersion;

public class Solution {
    public static boolean isBadVersion(int n) {
        return n >= 1;
    }

//    public static int firstBadVersion(int n) {
//        if(n == 1) return 1;
//        for(int i = n+1; i >= 1; i--) {
//            if(!isBadVersion(i-1)) return i;
//        }
//
//        return 0;
//
//    }

    public static int firstBadVersion(int n) {
        if(n == 1) return 1;

        int left = 1, right = n;
        int mid = left + (right - left) / 2;;

        while (left <= right) {
            if(isBadVersion(mid)) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }

            if(!isBadVersion(mid) && isBadVersion(mid+1)) {
                return mid+1;
            }

            mid = left + (right - left) / 2;
        }


        return 0;

    }



    public static void main(String[] args) {
        System.out.println(firstBadVersion(2));
    }
}
