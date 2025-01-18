package org.aktic.titleToNumber;

public class Solution {
    public static int titleToNumber(String columnTitle) {
        int pow = columnTitle.length()-1;
        int column = 0;

        for(char c: columnTitle.toCharArray()) {
            int index = c - 'A' + 1;
            column += (int) (index * Math.pow(26, pow));
            pow--;
        }

        if(column < 0) return 2147483647;

        return column;

    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AAA"));
    }
}
