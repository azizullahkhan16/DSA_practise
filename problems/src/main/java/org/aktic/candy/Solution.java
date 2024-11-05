package org.aktic.candy;

import java.util.Arrays;

public class Solution {
    public static int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        for (int i = 0; i < ratings.length; i++) {
            if(i-1 >= 0 && i+1 < ratings.length) {
                if(ratings[i] > ratings[i+1] && ratings[i] > ratings[i-1]) {
                    candies[i] = Math.max(candies[i+1], candies[i-1])+1;
                } else if(ratings[i] >= ratings[i-1]) {
                    candies[i] = candies[i-1]+1;
                }
            } else if(i-1 < 0 && ratings[i] > ratings[i+1]) {
                candies[i] = candies[i+1]+1;
            } else if(i+1 >= ratings.length && ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1]+1;
            }
        }


        int min = 0;
        for(int i : candies) {
            min += i;
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(candy(new int[] {1,2,87,87,87,2,1}));
    }
}
