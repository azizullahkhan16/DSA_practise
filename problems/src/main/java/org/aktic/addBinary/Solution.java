package org.aktic.addBinary;

import java.util.Map;

public class Solution {
    public static String addBinary(String a, String b) {
        int carry = 0;
        String sum = "";

        int left = a.length() - 1;
        int right = b.length() - 1;

        int A = 0, B = 0, plus = 0;

        while (left >= 0 || right >= 0) {
            if (left >= 0 && right >= 0) {
                A = Character.getNumericValue(a.charAt(left));
                B = Character.getNumericValue(b.charAt(right));
                plus = A + B + carry;

                if(plus == 0) {
                    sum = Integer.toString(plus) + sum;
                    carry = 0;
                } else if(plus == 1) {
                    sum = Integer.toString(plus) + sum;
                    carry = 0;
                }
                else if(plus == 2) {
                    carry = 1;
                    sum = "0" + sum;
                } else {
                    carry = 1;
                    sum = "1" + sum;
                }
                left--;
                right--;
            }else if(left >= 0) {
                A = Character.getNumericValue(a.charAt(left));
                plus = A + carry;

                if(plus == 0) {
                    sum = Integer.toString(plus) + sum;
                    carry = 0;
                } else if(plus == 1) {
                    sum = Integer.toString(plus) + sum;
                    carry = 0;
                }
                else if(plus == 2) {
                    carry = 1;
                    sum = "0" + sum;
                }
                left--;
            }else if(right >= 0) {
                A = Character.getNumericValue(b.charAt(right));
                plus = A + carry;

                if(plus == 0) {
                    sum = Integer.toString(plus) + sum;
                    carry = 0;
                } else if(plus == 1) {
                    sum = Integer.toString(plus) + sum;
                    carry = 0;
                }
                else if(plus == 2) {
                    carry = 1;
                    sum = "0" + sum;
                }
                right--;
            }
        }
        if(carry == 1) sum = carry + sum;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(addBinary("101111", "10"));
    }



}
