package org.aktic.matchPlayersAndTrainers;

import java.util.Arrays;

public class Solution {
    public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int left = players.length - 1;
        int right = trainers.length - 1;
        int count = 0;

        while (left >= 0 && right >= 0) {
            if (players[left] <= trainers[right]) {
                count++;
                left--;
                right--;
            } else {
                left--;
            }
        }


        return count;
    }

    public static void main(String[] args) {
        System.out.println(matchPlayersAndTrainers(new int[]{1, 1, 1}, new int[]{10}));
    }
}
