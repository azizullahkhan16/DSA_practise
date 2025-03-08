package org.aktic.minimumRecolors;

public class Solution {
    public static int minimumRecolors(String blocks, int k) {
        int left = 0;
        int right = k - 1;
        int min = 0;

        for (int i = 0; i <= right; i++) {
            if (blocks.charAt(i) == 'W') min++;
        }

        if (min == 0) return 0;

        int currMin = min;

        for (; right < blocks.length() - 1; right++) {
            if (blocks.charAt(right + 1) == 'B' && blocks.charAt(left) == 'W') {
                currMin--;
            } else if (blocks.charAt(right + 1) == 'W' && blocks.charAt(left) == 'B') {
                currMin++;
            }
            left++;

            min = Math.min(min, currMin);
            if (min == 0) return 0;
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(minimumRecolors("WBWBBBW", 2));
    }
}
