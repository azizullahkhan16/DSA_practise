package org.aktic.getLongestSubsequence;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int left = 0;
        int right = 1;

        List<Integer> indexes = new ArrayList<>();
        indexes.add(0);

        while (right < groups.length) {
            if (groups[indexes.getLast()] != groups[right]) {
                indexes.add(right);
            }

            right++;
        }

        List<String> res = new ArrayList<>();

        for (Integer i : indexes) {
            res.add(words[i]);
        }


        return res;

    }
}
