package org.aktic.intToRoman;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static String intToRoman(int num) {
        Map<Integer, Character> map = new HashMap<Integer, Character>();
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');

        int[] arr = {1000, 500, 100, 50, 10, 5, 1};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length && num > 0; i++) {
            if(num == 4) {
                sb.append("IV");
                num -= 4;
            }
            else if(num == 9) {
                sb.append("IX");
                num -= 9;
            }
            else {
                if(num >= 900 && arr[i] == 500) continue;
                if(num >= 90 && arr[i] == 50) continue;
                int temp = num/arr[i];
                if(temp == 4) {
                    if(temp*arr[i] == 400) sb.append("CD");
                    else if(temp*arr[i] == 40) sb.append("XL");
                    else if(temp*arr[i] == 4) sb.append("IV");
                } else if(temp == 9) {
                    if(temp*arr[i] == 900) sb.append("CM");
                    else if(temp*arr[i] == 90) sb.append("XC");
                    else if(temp*arr[i] == 9) sb.append("IX");
                } else {
                    for (int j = 0; j < temp; j++) {
                        sb.append(map.get(arr[i]));
                    }
                }
                num = num - (temp*arr[i]);
            }

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}
