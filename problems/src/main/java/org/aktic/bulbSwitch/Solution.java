package org.aktic.bulbSwitch;

import java.util.Arrays;

public class Solution {
//    public static int bulbSwitch(int n) {
//        if(n == 0) return 0;
//        if(n == 1) return 1;
//        if(n == 2 || n == 3) return 1;
//
//        boolean[] bulbs = new boolean[n];
//
//        // first round
//        Arrays.fill(bulbs, true);
//
//        // second round
//        for (int i = 1; i < bulbs.length; i+=2) {
//            bulbs[i] = false;
//        }
//
//        // third round
//        for (int i = 3; i <= n; i++) {
//            for (int j = i-1; j < bulbs.length; j+=i) {
//                bulbs[j] = !bulbs[j];
//            }
//        }
//
//        int count = 0;
//        for (boolean bulb : bulbs) {
//            if(bulb) count++;
//        }
//
//        return count;
//    }

    public static int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    public static void main(String[] args) {
        System.out.println(bulbSwitch(5));
    }
}
