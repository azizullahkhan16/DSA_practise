package org.aktic.shortestCompletingWord;

import java.util.HashMap;
import java.util.Map;

public class Solution {

//    public static String shortestCompletingWord(String licensePlate, String[] words) {
//        licensePlate = licensePlate.toLowerCase().replaceAll("\\d", "").replaceAll("\\s", "");
//
//        Map<String, Integer> map = new HashMap<String, Integer>();
//
//        for (String word : words) {
//            map.put(word, 0);
//        }
//
//
//        for(String key : map.keySet()) {
//            for (int i = 0; i < licensePlate.length(); i++) {
//                if(key.contains(licensePlate.substring(i, i+1))) {
//                    map.put(key, map.get(key) + 1);
//                }
//            }
//        }
//
//        String result = "";
//        int shortest = Integer.MAX_VALUE;
//
//        for(String key : map.keySet()) {
//            if(map.get(key) == licensePlate.length()) {
//                if(key.length() < shortest) {
//                    shortest = key.length();
//                    result = key;
//                }
//            }
//        }
//
//
//
//        return result;
//
//    }


    public static String shortestCompletingWord(String licensePlate, String[] words) {

        int[] licensePlateCounts = new int[26];

        for(char c: licensePlate.toCharArray()) {
            if(Character.isAlphabetic(c)) {
                char ch = Character.toLowerCase(c);
                licensePlateCounts[ch-'a']++;
            }
        }

        String ans = null;
        for(String s: words) {

            int[] stringCounts = new int[26];
            for(Character c : s.toCharArray()) {
                stringCounts[Character.toLowerCase(c)-'a']++;
            }

            boolean exist = true;
            for(int i =0; i < 26; i++) {

                if(stringCounts[i] < licensePlateCounts[i]) {
                    exist = false;
                    break;
                }
            }

            if(exist) {
                ans = (ans == null || s.length() < ans.length() ? s : ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(shortestCompletingWord("1s3 PSt", new String[] {"step","steps","stripe","stepple"}));
    }
}
