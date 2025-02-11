package org.aktic.removeOccurrences;

public class Solution {
    public static String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (sb.length() < part.length() - 1) {
                sb.append(s.charAt(i));
            } else {
                sb.append(s.charAt(i));

                if (sb.substring(sb.length() - part.length(), sb.length()).equals(part)) {
                    sb.delete(sb.length() - part.length(), sb.length());
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOccurrences("daabcbaabcbc", "abc"));
    }
}
