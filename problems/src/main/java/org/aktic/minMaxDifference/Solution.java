package org.aktic.minMaxDifference;

public class Solution {
    public static int minMaxDifference(int num) {
        String number = String.valueOf(num);
        String maxNum = "";
        String minNum = "";

        char maxDigit = '9';
        char minDigit = number.charAt(0) == '9' ? '9' : number.charAt(0);

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != '9') {
                maxDigit = number.charAt(i);
                break;
            }
        }

        for (int i = 0; i < number.length(); i++) {
            maxNum += number.charAt(i) == maxDigit ? '9' : number.charAt(i);
            minNum += number.charAt(i) == minDigit ? '0' : number.charAt(i);
        }

        int min = Integer.parseInt(minNum);
        int max = Integer.parseInt(maxNum);

        return max - min;

    }

    public static void main(String[] args) {
        System.out.println(minMaxDifference(11891));
    }
}
