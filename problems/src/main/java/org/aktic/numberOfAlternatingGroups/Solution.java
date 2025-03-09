package org.aktic.numberOfAlternatingGroups;

public class Solution {
    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int left = 0;
        int right = 0;
        int count = 0;

        for (; left < colors.length; right++) {
            if (colors[right % colors.length] == colors[(right + 1) % colors.length]) {
                left = right;
            } else if (colors[right % colors.length] != colors[(right + 1) % colors.length] && right - left == k - 1) {
                count++;
                left++;
            }
        }
        
        return count;
    }

    public static boolean checkAlternate(int[] colors, int left, int right) {
        for (int i = left; i < right; i++) {
            if (colors[i % colors.length] == colors[(i + 1) % colors.length]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(numberOfAlternatingGroups(new int[]{0, 1, 0, 1, 0}, 3));
    }
}
