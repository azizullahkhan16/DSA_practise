package org.aktic.timeRequiredToBuy;

public class Solution {
    public static int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        for (int i = 0; i < tickets.length; i++) {
            if(i == k) time += tickets[i];
            else if(i < k) {
                if(tickets[i] >= tickets[k]) time += tickets[k];
                else time += tickets[i];
            }else {
                if(tickets[i] >= tickets[k]) time += tickets[k]-1;
                else time += tickets[i];
            }

        }

        return time;
    }

    public static void main(String[] args) {
        System.out.println(timeRequiredToBuy(new int[] {5,1,1,1}, 0));
    }
}
