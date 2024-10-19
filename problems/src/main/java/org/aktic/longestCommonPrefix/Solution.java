package org.aktic.longestCommonPrefix;

import java.util.Arrays;

public class Solution {
//    public static String longestCommonPrefix(String[] strs) {
//        if(strs[0].isEmpty()) return "";
//        String prefix = strs[0];
//
//        for (int i = 1; i < strs.length && !prefix.isEmpty(); i++) {
//            String updatePrefix = "";
//            for(int j = 0; j < Math.min(prefix.length(), strs[i].length()) && !prefix.isEmpty(); j++) {
//                if(strs[i].charAt(j) == prefix.charAt(j)) {
//                    updatePrefix = updatePrefix + strs[i].charAt(j);
//                } else break;
//            }
//            if(updatePrefix.isEmpty()) return "";
//            else prefix = updatePrefix;
//        }
//
//
//        return prefix;
//    }


    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        int index = 0;
        while (index < s1.length() && index < s2.length()) {
            if (s1.charAt(index) == s2.charAt(index)) {
                index++;
            }
            else {
                break;
            }
        }
        return s1.substring(0, index);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}

