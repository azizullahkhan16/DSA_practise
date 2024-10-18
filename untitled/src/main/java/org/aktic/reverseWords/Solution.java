package org.aktic.reverseWords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static String reverseWords(String s) {
        String[] res = s.trim().split("\\s+");

        Collections.reverse(Arrays.asList(res));
        List<String> list = Arrays.asList(res);

        return String.join(" ", res);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }
}

