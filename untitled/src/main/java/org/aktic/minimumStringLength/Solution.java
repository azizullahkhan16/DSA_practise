package org.aktic.minimumStringLength;

class Solution {
    public static int minLength(String s) {
        String newString = "";
        String temp = "";

        for (int i = 0; i < ; i++) {
            
        }
        for (int i = 0; i < s.length()-2; i+=2) {
            temp = s.substring(i, i+2);
            if(temp != "AB" || temp != "CD") newString += temp;
        }



        return newString.length();
    }

    public static void main(String[] args) {

    }
}