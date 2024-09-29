package org.aktic.addBinary;

import java.util.Map;

public class Solution {
    public static String addBinary(String a, String b) {
        int max = Math.max(a.length(), b.length());
        char[] maxArray;

        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        char[] R = new char[max+1];

        for (int i = 0; i < R.length; i++) {
            R[i] = '0';
        }

        if(max == A.length) maxArray = A;
        else maxArray = B;

        char carry = '0';
        char sum = '0';

        for (int i = max-1; i >= 0; i--) {
            if(carry == '0' && ((A[i] == '0' && B[i] == '1') || (A[i] == '1' && B[i] == '0'))) {
                carry = '0';
                sum = '1';
            }else if(carry == '1' && ((A[i] == '0' && B[i] == '1') || (A[i] == '1' && B[i] == '0'))) {
                carry = '1';
                sum = '0';
            } else if(carry == '1' && A[i] == '1' && B[i] == '1') {
                carry = '1';
                sum = '1';
            }else if(carry == '0' && A[i] == '1' && B[i] == '1') {
                carry = '1';
                sum = '1';
            }

            R[i+1] = sum;
        }

        return new String(R);

    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "11"));
    }



}
