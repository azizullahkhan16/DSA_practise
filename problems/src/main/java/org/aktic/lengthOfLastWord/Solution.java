package org.aktic.lengthOfLastWord;

public class Solution {
    public static int lengthOfLastWord(String s) {
        s = s.trim();
        int count = 0;

        for (int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == ' ') break;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
