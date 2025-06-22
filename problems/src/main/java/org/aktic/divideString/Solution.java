package org.aktic.divideString;

import java.util.Arrays;

public class Solution {
    public static String[] divideString(String s, int k, char fill) {
        String[] res = new String[s.length() % k == 0 ? s.length() / k : (s.length() / k) + 1];
        int index = 0;

        for (int i = 0; i < s.length(); i += k) {
            String temp;
            if (i + k <= s.length()) {
                temp = s.substring(i, i + k);
            } else {
                temp = s.substring(i);
                int outbound = k - temp.length();
                for (int j = 0; j < outbound; j++) {
                    temp += fill;
                }
            }

            res[index++] = temp;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(divideString("bgycymgbblobvpdf", 67, 'u')));
    }
}
