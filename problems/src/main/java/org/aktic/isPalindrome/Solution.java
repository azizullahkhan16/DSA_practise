package org.aktic.isPalindrome;

public class Solution {
    public static boolean isPalindrome(String s) {
        String refined = s.toLowerCase().replaceAll("\\s", "").replaceAll("[^a-zA-Z0-9]", "");

        int left;
        int right = 0;
        if(!refined.isEmpty()) {
            right = refined.length() - 1;

            for (left = 0; left < refined.length()/2 + 1; left++) {
                if(refined.charAt(left) != refined.charAt(right)) {
                    return false;
                }
                right--;
            }
        }


        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(" "));
    }
}
