package org.aktic.motiveQ3_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static String[] findWinnerFromLaps(String[][] laps) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < laps.length; i++) {
            int maxTime = Integer.MIN_VALUE;

            for (int j = 0; j < laps[0].length; j++) {
                String[] sp = laps[i][j].split(" ");
                int score = Integer.parseInt(sp[1]);
                maxTime = Math.max(score, maxTime);
            }

            List<String> el = new ArrayList<>();

            for (int j = 0; j < laps[0].length; j++) {
                String[] sp = laps[i][j].split(" ");
                String driver = sp[0];

                int score = Integer.parseInt(sp[1]);
                if (score == maxTime) {
                    el.add(driver);
                }
            }

            Collections.sort(el);
            res.addAll(el);
        }

        String[] result = new String[res.size()];

        return res.toArray(result);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findWinnerFromLaps(
                new String[][]{{"Harold 155", "Gina 153", "John 156"},
                        {"Gina 153", "Harold 153", "John 152"},
                        {"John 151", "Gina 152", "Harold 154"}})));
    }
}
