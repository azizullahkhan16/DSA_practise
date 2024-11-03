package org.aktic.canCompleteCircuit;

import java.util.Map;

public class Solution {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGain = 0;
        int currentGain = 0;
        int startStation = 0;

        for (int i = 0; i < gas.length; i++) {
            int netGain = gas[i] - cost[i];
            totalGain += netGain;
            currentGain += netGain;

            if (currentGain < 0) {
                startStation = i + 1;
                currentGain = 0;
            }
        }

        return totalGain >= 0 ? startStation : -1;
    }


    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{4,5,2,6,5,3}, new int[] {3,2,7,3,2,9}));
    }
}
