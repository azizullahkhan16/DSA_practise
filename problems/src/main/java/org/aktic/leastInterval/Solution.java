package org.aktic.leastInterval;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }

        int maxCount = 0;
        int maxChars = 0;

        for (int count : map) {
            if (count > maxCount) {
                maxCount = count;
                maxChars = 1;
            } else if (count == maxCount) {
                maxChars++;
            }
        }

        return Math.max((maxCount - 1) * (n + 1) + maxChars, tasks.length);
    }

    public static void main(String[] args) {
        System.out.println(leastInterval(new char[] {'A','C','A','B','D','B'}, 1));
    }
}
