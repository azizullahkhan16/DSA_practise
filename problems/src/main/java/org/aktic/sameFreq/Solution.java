package org.aktic.sameFreq;

public class Solution {
    static boolean sameFreq(String s) {
        // code here
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        if (isSame(count)) return true;

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                count[i]--;
                if (isSame(count)) return true;
                count[i]++;
            }
        }

        return false;

    }

    static boolean isSame(int[] count) {
        int prev = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                if (prev == 0) prev = count[i];
                else if (prev != count[i]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(sameFreq("xxxxyyzz"));
    }
}
