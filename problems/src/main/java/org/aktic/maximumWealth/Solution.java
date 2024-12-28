package org.aktic.maximumWealth;

public class Solution {
    public static int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        int wealth;

        for (int i = 0; i < accounts.length; i++) {
            wealth = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                wealth += accounts[i][j];
            }
            maxWealth = Math.max(maxWealth, wealth);
        }

        return maxWealth;

    }

    public static void main(String[] args) {

    }
}
