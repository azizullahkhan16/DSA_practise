package org.aktic.checkPowersOfThree;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static boolean checkPowersOfThree(int n) {
        Set<Integer> set = new HashSet<>();
        while (n > 0) {
            int pow = 0;

            while (Math.pow(3, pow) <= n) {
                pow++;
            }

            if (set.contains(pow - 1)) break;
            else set.add(pow - 1);

            n -= (int) Math.pow(3, pow - 1);
        }


        return n == 0;

    }

    public static void main(String[] args) {
        System.out.println(checkPowersOfThree(91));
    }
}
