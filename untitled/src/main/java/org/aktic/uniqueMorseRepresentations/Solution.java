package org.aktic.uniqueMorseRepresentations;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static int uniqueMorseRepresentations(String[] words) {
        HashMap<Character, String> mp = new HashMap<>();
        mp.put('a', ".-");
        mp.put('b', "-...");
        mp.put('c', "-.-.");
        mp.put('d', "-..");
        mp.put('e', ".");
        mp.put('f', "..-.");
        mp.put('g', "--.");
        mp.put('h', "....");
        mp.put('i', "..");
        mp.put('j', ".---");
        mp.put('k', "-.-");
        mp.put('l', ".-..");
        mp.put('m', "--");
        mp.put('n', "-.");
        mp.put('o', "---");
        mp.put('p', ".--.");
        mp.put('q', "--.-");
        mp.put('r', ".-.");
        mp.put('s', "...");
        mp.put('t', "-");
        mp.put('u', "..-");
        mp.put('v', "...-");
        mp.put('w', ".--");
        mp.put('x', "-..-");
        mp.put('y', "-.--");
        mp.put('z', "--..");

        String temp = "";
        Set<String> unique = new HashSet<>();
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                temp += mp.get(words[i].charAt(j));
            }

            unique.add(temp);
            temp = "";
        }
        return unique.size();
    }

    public static void main(String[] args) {
        System.out.println(uniqueMorseRepresentations(new String[]{"gin", "gig","zen", "msg"}));
    }
}
