package org.aktic.coloredCells;

public class Solution {
    public static long coloredCells(int n) {
        if (n == 1) return n;

        long mul4 = 1;
        long colored = 1;
        for (int i = 1; i < n; i++) {
            colored += 4 * mul4;
            mul4++;
        }

        return colored;
    }

    public static void main(String[] args) {
        System.out.println(coloredCells(3));
    }
}
