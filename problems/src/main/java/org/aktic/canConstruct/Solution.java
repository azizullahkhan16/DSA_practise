package org.aktic.canConstruct;

public class Solution {
    public static boolean canConstruct(String s, int k) {
        if(s.length() < k) return false;
        if(s.length() == k) return true;

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        int oddCount = 0;
        for (int i = 0; i < count.length; i++) {
            if(count[i] % 2 == 1) oddCount++;
        }

        return oddCount <= k;

    }

    public static void main(String[] args) {
        System.out.println(canConstruct("annabelle", 3));
    }
}
