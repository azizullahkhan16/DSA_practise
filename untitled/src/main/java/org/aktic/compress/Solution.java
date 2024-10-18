package org.aktic.compress;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int compress(char[] chars) {
        int n = chars.length;
        int write = 0;
        int read = 0;

        while (read < n) {
            char currentChar = chars[read];
            int count = 0;


            while (read < n && chars[read] == currentChar) {
                read++;
                count++;
            }

            chars[write++] = currentChar;


            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }


    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
    }
}
