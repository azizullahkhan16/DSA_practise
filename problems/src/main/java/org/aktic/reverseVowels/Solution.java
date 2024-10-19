package org.aktic.reverseVowels;

public class Solution {
    public static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if(isVowel(s.charAt(left)) && isVowel(s.charAt(right))) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
            if (!isVowel(chars[left])) left++;
            if (!isVowel(chars[right])) right--;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("letcode"));
    }
}
