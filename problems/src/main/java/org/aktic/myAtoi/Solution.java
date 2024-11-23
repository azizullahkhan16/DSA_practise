package org.aktic.myAtoi;

public class Solution {
    public static int myAtoi(String s) {
        if(s.isEmpty()) return 0;
        s = s.trim();
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s);
        boolean negative = false;

        if (sb.charAt(0) == '-') {
            negative = true;
            sb.deleteCharAt(0);
        }else if(sb.charAt(0) == '+') {
            sb.deleteCharAt(0);
        }else if (Character.isLetter(sb.charAt(0))) {
            return 0;
        }

        if(sb.isEmpty()) return 0;

        boolean firstDigit = false;
        int zeroes = 0;
        for (int i = 0; i < sb.length(); i++) {
            if(Character.isDigit(sb.charAt(i)) && !firstDigit && sb.charAt(i) == '0') {
                zeroes++;
            }else if(Character.isDigit(sb.charAt(i)) && !firstDigit && sb.charAt(i) != '0'){
                firstDigit = true;
            }

            if(!Character.isDigit(sb.charAt(i))) {
                sb.delete(i, sb.length());
            }
        }
        if(zeroes > 0) sb.delete(0, zeroes+1);
        if(sb.isEmpty()) return 0;
        int result;
        try {
            result = negative ? -Integer.parseInt(sb.toString()) : Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            result = negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("    0000000000000   "));
    }
}
