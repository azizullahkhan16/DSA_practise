package org.aktic.isHappy;

public class Solution {
    public static boolean isHappy(int n) {
        if(n == 1) return true;
        else if(n < 4) return false;

        String num = Integer.toString(n);
        int sum = 0;

        for (int i = 0; i < num.length(); i++) {
            sum += (num.charAt(i) - '0')*(num.charAt(i) - '0');
        }

        return isHappy(sum);
    }

    public static void main(String[] args) {
        System.out.println(isHappy(7));
    }
}
