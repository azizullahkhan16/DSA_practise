package org.aktic.numberOfPowerfulInt;

public class Solution {
    public static long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        long count = 0;
        int num = Integer.parseInt(s);
        int index = 0;
        int shift = 0;

        while (true) {
            if (num > finish) break;

            String temp = String.valueOf(index) + String.valueOf(num);

            int val = Integer.parseInt(temp);

            if (val >= start) count++;

            if (index == limit) shift++;
        }

        return count;
    }


}
