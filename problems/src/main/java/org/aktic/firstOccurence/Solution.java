package org.aktic.firstOccurence;

public class Solution {
    static int firstOccurence(String txt, String pat) {
        // Your code here
        for (int i = 0; i < txt.length() - pat.length(); i++) {
            String temp = txt.substring(i, i + pat.length());

            if (temp.equals(pat)) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstOccurence("GeeksForGeeks", "For"));
    }
}
