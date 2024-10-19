package org.aktic.largestAltitude;

public class Solution {
    public static int largestAltitude(int[] gain) {
        int maxAlt = 0;
        int currentAlt = 0;

        for (int i = 0; i < gain.length; i++) {
            currentAlt += gain[i];
            maxAlt = Math.max(maxAlt, currentAlt);
        }

        return maxAlt;
    }

    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[] {-4,-3,-2,-1,4,3,2}));
    }
}
