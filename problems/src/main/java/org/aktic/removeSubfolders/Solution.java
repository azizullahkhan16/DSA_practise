package org.aktic.removeSubfolders;

import java.util.*;

public class Solution {
    public static List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, Comparator.comparingInt(s -> s.split("/").length));
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (String s : folder) {
            List<String> temp = stringSplit(s);
            StringBuilder concat = new StringBuilder();
            boolean hasString = false;

            for (int i = 0; i < temp.size(); i++) {
                concat.append(temp.get(i));
                if (set.contains(concat.toString())) {
                    hasString = true;
                    break;
                }
            }

            if (!hasString) {
                set.add(s);
                res.add(s);
            }
        }

        return res;
    }

    private static List<String> stringSplit(String s) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            int index = i + 1;
            StringBuilder temp = new StringBuilder("/");

            while (index < s.length() && s.charAt(index) != '/') {
                temp.append(s.charAt(index++));
            }

            res.add(temp.toString());
            i = index - 1;

        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println((removeSubfolders(new String[]{"/ah/al/am", "/ah/al"})));
    }
}
