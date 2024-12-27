package org.aktic.toLowerCase;

public class Solution {
    public static String toLowerCase(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') result += (char)(s.charAt(i) + 32);
            else result += s.charAt(i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(toLowerCase("Hello"));
    }
}
