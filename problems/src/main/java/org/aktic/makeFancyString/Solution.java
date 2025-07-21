package org.aktic.makeFancyString;

public class Solution {
    public static String makeFancyString(String s) {
        StringBuilder res = new StringBuilder();

        for (int i = 1; i < s.length() + 1; i++) {
            res.append(s.charAt(i - 1));
            int count = 1;
            int temp = i;

            while (temp < s.length() && s.charAt(temp) == s.charAt(temp - 1)) {
                count++;
                if (count <= 2) res.append(s.charAt(temp));
                temp++;
            }

            i = temp;
        }

        return res.toString();
    }


    public static void main(String[] args) {
        System.out.println(makeFancyString("aaabaaaa"));
    }
}
