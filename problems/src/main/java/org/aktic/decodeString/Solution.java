package org.aktic.decodeString;

import java.util.Stack;

public class Solution {
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resultStack = new Stack<>();
        String currentString = "";
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(k);
                resultStack.push(currentString);
                currentString = "";
                k = 0;
            } else if (ch == ']') {
                StringBuilder temp = new StringBuilder(resultStack.pop());
                int repeatTimes = countStack.pop();
                temp.append(currentString.repeat(repeatTimes));
                currentString = temp.toString();
            } else {
                currentString += ch;
            }
        }

        return currentString;
    }


    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }
}