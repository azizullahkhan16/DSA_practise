package org.aktic.groupAnagrams;

import java.util.*;

public class Solution {
//    public static List<List<String>> groupAnagrams(String[] strs) {
//        Map<String, List<String>> map = new HashMap<>();
//
//        for (int i = 0; i < strs.length; i++) {
//            if(map.isEmpty()) {
//                ArrayList<String> list = new ArrayList<>();
//                list.add(strs[i]);
//                map.put(strs[i], list);
//            } else {
//                boolean found = false;
//                for(Map.Entry<String, List<String>> entry : map.entrySet()) {
//                    if(isAnagram(strs[i], entry.getKey())) {
//                        entry.getValue().add(strs[i]);
//                        found = true;
//                        break;
//                    }
//                }
//                if(!found) {
//                    ArrayList<String> list = new ArrayList<>();
//                    list.add(strs[i]);
//                    map.put(strs[i], list);
//                }
//            }
//        }
//
//        return new ArrayList<>(map.values());
//
//    }
//
//    public static boolean isAnagram(String a, String b) {
//        char[] A = a.toCharArray();
//        char[] B = b.toCharArray();
//        Arrays.sort(A);
//        Arrays.sort(B);
//        return Arrays.equals(A, B);
//    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            if(map.containsKey(String.valueOf(chars))) {
                map.get(String.valueOf(chars)).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(String.valueOf(chars), list);
            }
        }

        return new ArrayList<>(map.values());
    }

    public static boolean isAnagram(String a, String b) {
        if(a.length() != b.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0) + 1);
        }
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < b.length(); i++) {
            map2.put(b.charAt(i), map2.getOrDefault(b.charAt(i), 0) + 1);
        }

        for (int i = 0; i < a.length(); i++) {
            if (map.get(a.charAt(i)) != map2.get(a.charAt(i))) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] res = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
//        Arrays.sort(res);
//        System.out.println(Arrays.toString(res));
    }
}
