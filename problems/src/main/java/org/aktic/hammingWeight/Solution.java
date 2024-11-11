package org.aktic.hammingWeight;

public class Solution {
    public static int hammingWeight(int n) {
        int ones = 0;

        while (n != 0) {
            if(n%2 == 1) ones++;

            n = n/2;
        }

        return ones;

    }


    public static void main(String[] args) {
        System.out.println(hammingWeight(128));
    }
}
