package org.aktic.romanToInteger;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int romanToInt(String s) {
        char[] S = s.toCharArray();
        int res = 0;

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);


        for (int i = 0; i < S.length; i++) {
            if(i+1 < S.length) {
                if(S[i] == 'I' && S[i+1] == 'V') {
                    res += 4;
                    i++;
                }else if(S[i] == 'I' && S[i+1] == 'X') {
                    res += 9;
                    i++;
                }else if(S[i] == 'X' && S[i+1] == 'L') {
                    res += 40;
                    i++;
                }else if(S[i] == 'X' && S[i+1] == 'C') {
                    res += 90;
                    i++;
                }else if(S[i] == 'C' && S[i+1] == 'D') {
                    res += 400;
                    i++;
                } else if(S[i] == 'C' && S[i+1] == 'M') {
                    res += 900;
                    i++;
                } else res += map.get(S[i]);
            } else res += map.get(S[i]);

        }

        return res;

    }


    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }
}
