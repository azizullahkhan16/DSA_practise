package org.aktic.palindromicInteger;

public class Solution {
    public static boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x < 10) return true;

        String var = Integer.toString(x);

        int left;
        int right = var.length() - 1;

        for (left = 0; left <= right; left++) {
            if(var.charAt(left) != var.charAt(right)) return false;
            right--;
        }


        return true;
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome(12));
    }
}
