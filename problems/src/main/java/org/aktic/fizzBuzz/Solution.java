package org.aktic.fizzBuzz;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<String>();

        for (int i = 1; i <= n; i++) {
            if(i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            }else if(i % 3 == 0) {
                list.add("Fizz");
            }else if(i % 5 == 0) {
                list.add("Buzz");
            }else {
                list.add(String.valueOf(i));
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(fizzBuzz(5));
    }
}
