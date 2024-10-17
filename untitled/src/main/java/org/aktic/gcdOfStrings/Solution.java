package org.aktic.gcdOfStrings;

public class Solution {
    public static String gcdOfStrings(String str1, String str2) {
        int left = 0;
        int right = 0;
        String result = "";
        String res = "";

        while (left < str1.length() && right < str2.length()) {
            if (str1.charAt(left) == str2.charAt(right)) {
                result += str1.charAt(left);

                while (left < str1.length()) {
                    if(!result.equals(str1.substring(left, left+result.length()))) res += result;
                    left += result.length();
                }

                while (right < str2.length()) {
                    if(!result.equals(str2.substring(right, right+result.length()))) return "";
                    right += result.length();
                }

                left++;
                right++;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABABAB", "ABAB"));
    }
}
