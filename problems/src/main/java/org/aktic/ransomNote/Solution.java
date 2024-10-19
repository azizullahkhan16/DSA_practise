package org.aktic.ransomNote;

import java.util.Arrays;

public class Solution {

    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] R = ransomNote.toCharArray();
        char[] M = magazine.toCharArray();

        Arrays.sort(R);
        Arrays.sort(M);

        int left = 0;
        int right = 0;

        for (right = 0; right < M.length; right++) {
            if(R[left] == M[right]) {
                left++;
            }

            if(left == R.length) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("fac", "cedab"));
    }



}
