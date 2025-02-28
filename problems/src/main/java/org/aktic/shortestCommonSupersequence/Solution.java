package org.aktic.shortestCommonSupersequence;

public class Solution {
    public static String shortestCommonSupersequence1(String str1, String str2) {
        return backkTrack(0, 0, str1, str2);
    }


    private static String backkTrack(int i, int j, String str1, String str2) {
        if (i == str1.length()) return str2.substring(j);
        if (j == str2.length()) return str1.substring(i);

        if (str1.charAt(i) == str2.charAt(j)) {
            return str1.charAt(i) + backkTrack(i + 1, j + 1, str1, str2);
        }

        String res1 = str1.charAt(i) + backkTrack(i + 1, j, str1, str2);
        String res2 = str2.charAt(j) + backkTrack(i, j + 1, str1, str2);

        return res1.length() > res2.length() ? res2 : res1;
    }

    public static String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        String[] prevRow = new String[str2.length() + 1];
        for (int col = 0; col <= n; col++) {
            prevRow[col] = str2.substring(0, col);
        }

        for (int row = 1; row <= m; row++) {
            String[] currRow = new String[n + 1];
            currRow[0] = str1.substring(0, row);

            for (int col = 1; col <= n; col++) {
                if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
                    currRow[col] = prevRow[col - 1] + str1.charAt(row - 1);
                } else {
                    String pickS1 = prevRow[col];
                    String pickS2 = currRow[col - 1];

                    currRow[col] = (pickS1.length() < pickS2.length())
                            ? pickS1 + str1.charAt(row - 1)
                            : pickS2 + str2.charAt(col - 1);
                }
            }
            prevRow = currRow;
        }

        return prevRow[n];
    }

    public static void main(String[] args) {
        System.out.println(shortestCommonSupersequence("ax", "ay"));
    }
}
