package org.aktic.repairCars;

public class Solution {
    public static long repairCars(int[] ranks, int cars) {
        long left = 1;
        long right = (long) (ranks[0] * Math.pow(cars, 2));
        long res = -1;
        while (left <= right) {
            long mid = left + (right - left) / 2;


            if (numCars(ranks, mid, cars) >= cars) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }


    public static int numCars(int[] ranks, long time, int cars) {
        int sum = 0;
        for (int i = 0; i < ranks.length; i++) {
            sum += (int) Math.sqrt((double) time / ranks[i]);
            if (sum > cars) break;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(repairCars(new int[]{4, 2, 3, 1}, 10));
    }
}
