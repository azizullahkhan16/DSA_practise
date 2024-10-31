package org.aktic.maxProfit;

public class Solution {
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 1) return 0;
        int maxProfit = 0;
        int buy = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if(buy == -1) buy = prices[i];
            else if(prices[i] <= buy) {
                buy = prices[i];
            }else if(prices[i] > buy) {
                if(i+1 < prices.length && prices[i+1] < prices[i]) {
                    maxProfit += prices[i]-buy;
                    buy = -1;
                }else if(i+1 >= prices.length && prices[i] > buy) {
                    maxProfit += prices[i]-buy;
                    buy = -1;
                }
            }
        }

        return maxProfit;

    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
