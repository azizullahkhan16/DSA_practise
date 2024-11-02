package org.aktic.canCompleteCircuit;

import java.util.Map;

public class Solution {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int deficit = 0;
        int gain = 0;
        int station = -1;

        for (int i = 0; i < gas.length; i++) {
            if(gas[i]-cost[i] >= 0) {
                gain += gas[i]-cost[i];

            } else if(gas[i]-cost[i]+gain < 0) {
                deficit += gas[i] - cost[i];
            }

            if(gas[i] - cost[i] > 0) station = i;
            else if(Math.abs(deficit) >= gain) station = -1;

        }

        return deficit + gain >= 0 ? station : -1;

    }

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{6,1,4,3,5}, new int[] {3,8,2,4,2}));
    }
}
