package org.aktic.minFlips;

public class Solution {
    public static int minFlips(int a, int b, int c) {
        int manipulation = 0;
        while (Math.max(c, Math.max(a, b)) > 0) {
            if(c%2 == 1) {
                if(a%2 != 1 && b%2 != 1) manipulation++;
            }else {
                if(a%2 == 1 && b%2 == 1) manipulation+=2;
                else if(a%2 == 1 || b%2 == 1) manipulation+=1;
            }
            a = a/2;
            b = b/2;
            c = c/2;
        }

        return manipulation;

    }

    public static void main(String[] args) {
        System.out.println(minFlips(8, 3, 5));
    }
}
