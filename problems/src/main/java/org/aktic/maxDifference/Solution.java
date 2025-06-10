package org.aktic.maxDifference;

public class Solution {

    public static int maxDifference(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int maxOdd = 0;
        int minEven = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 0 && count[i] != 0) {
                minEven = Math.min(minEven, count[i]);
            } else if (count[i] % 2 != 0) {
                maxOdd = Math.max(maxOdd, count[i]);
            }
        }

        return (maxOdd - minEven);
    }

    public static void main(String[] args) {
        System.out.println(maxDifference("aaaaabbc"));
    }
}
