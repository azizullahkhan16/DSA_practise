package org.aktic.average;

public class Solution {
    public static double average(int[] salary) {
        double sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num: salary) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            sum += num;
        }

        return (sum-max-min)/(salary.length-2);
    }

    public static void main(String[] args) {
        System.out.println(average(new int[] {4000,3000,1000,2000}));
    }
}
