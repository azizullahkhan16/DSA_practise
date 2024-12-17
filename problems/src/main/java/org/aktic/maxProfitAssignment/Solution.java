package org.aktic.maxProfitAssignment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];

        // Pair difficulty and profit into jobs array
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        // Sort jobs by difficulty, and if equal, by profit (not strictly necessary)
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // Sort workers by ability
        Arrays.sort(worker);

        // Precompute maximum profit for each difficulty
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, jobs[i][1]);
            jobs[i][1] = maxProfit; // Update profit to be the max profit up to this difficulty
        }

        // Assign workers to jobs
        int totalProfit = 0;
        int jobIndex = 0;

        for (int ability : worker) {
            // Find the most difficult job the worker can handle
            while (jobIndex < n && jobs[jobIndex][0] <= ability) {
                jobIndex++;
            }

            // Add the profit of the best job they can handle
            if (jobIndex > 0) {
                totalProfit += jobs[jobIndex - 1][1];
            }
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfitAssignment(new int[]{68,35,52,47,86}, new int[]{67,17,1,81,3}, new int[]{92,10,85,84,82}));
    }
}
