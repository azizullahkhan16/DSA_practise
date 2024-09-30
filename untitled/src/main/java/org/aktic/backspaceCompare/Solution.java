package org.aktic.backspaceCompare;

public class Solution {
    public static boolean backspaceCompare(String s, String t) {
        return emptyText(s).equals(emptyText(t));
    }

    public static String emptyText (String s) {
        String temp = "";

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '#' && !temp.isEmpty()) {
                temp = temp.substring(0, temp.length() - 1);
            } else if(s.charAt(i) != '#') temp += s.charAt(i);
        }

        return temp;
    }


    public static void main(String[] args) {
        System.out.println(backspaceCompare("y#fo##f", "y#f#o##f"));
    }
}
