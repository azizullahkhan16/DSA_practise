package org.aktic.addToArrayForm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
//    public static List<Integer> addToArrayForm(int[] num, int k) {
//        String sum = "";
//        for (int i = 0; i < num.length; i++) {
//            sum += num[i];
//        }
//        int res = Integer.parseInt(sum) + k;
//        List<Integer> result = new ArrayList<Integer>();
//        while (res > 0) {
//            result.add(res % 10);
//            res /= 10;
//        }
//        Collections.reverse(result);
//
//        return result;
//
//    }

    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();

        int left = num.length - 1;
        int sum = 0;
        int carry = 0;

        while (left >= 0 || k > 0) {
            if(left >= 0 && k > 0) {
                sum = (k%10) + num[left] + carry;

                if(sum < 10) {
                    carry = 0;
                    result.add(sum);
                }else {
                    carry = 1;
                    result.add(sum%10);
                }
                left--;
                k /= 10;
            }else if(left >= 0) {
                sum = num[left] + carry;
                if(sum < 10) {
                    carry = 0;
                    result.add(sum);
                }else {
                    carry = 1;
                    result.add(sum%10);
                }
                left--;
            } else if(k > 0) {
                sum = (k%10) + carry;
                if(sum < 10) {
                    carry = 0;
                    result.add(sum);
                }else {
                    carry = 1;
                    result.add(sum%10);
                }
                k /= 10;
            }
        }
        if(carry == 1) result.add(carry);

        Collections.reverse(result);


        return result;
    }


    public static void main(String[] args) {
        System.out.println(addToArrayForm(new int[]{9,9,9,9,9,9,9,9,9,9}, 1));
    }
}