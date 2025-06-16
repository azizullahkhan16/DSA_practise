package org.aktic.maxDiff;

public class Solution {
    public static int maxDiff(int num) {
        String number = String.valueOf(num);

        boolean isSame = true;
        for (int i = 1; i < number.length(); i++) {
            if (number.charAt(i - 1) != number.charAt(i)) {
                isSame = false;
                break;
            }
        }
        char temp = isSame || (number.charAt(0) != '1') ? '1' : '0';
        char a = '9';
        char b = temp;

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);

            if (c != '9' && a == '9') {
                a = c;
            }

            if (c != '1' && b == temp) {
                b = c;
            }
            if (a != '9' && b != temp) break;
        }

        String maximum = "";
        String minimum = "";

        for (char c : number.toCharArray()) {
            if (c == a) {
                maximum += '9';
            } else maximum += c;

            if (c == b) {
                minimum += temp;
            } else minimum += c;
        }

        return Integer.parseInt(maximum) - Integer.parseInt(minimum);
    }

    public static void main(String[] args) {
        System.out.println(maxDiff(9288));
    }
}
