package org.aktic.minimumDeletions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static int minimumDeletions(String word, int k) {
        int[] arr = new int[26];

        for (char c : word.toCharArray()) {
            arr[c - 'a']++;
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) list.add(arr[i]);
        }

        Collections.sort(list);

        int min = Integer.MAX_VALUE;
        int target;

        for (int i = 0; i < list.size(); i++) {
            target = list.get(i);
            int count = 0;

            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) < target) {
                    count += list.get(j);
                } else if (list.get(j) > (target + k)) {
                    count += list.get(j) - (target + k);
                }
            }

            min = Math.min(min, count);
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(minimumDeletions("zzfzzzzppfp", 1));
    }
}
