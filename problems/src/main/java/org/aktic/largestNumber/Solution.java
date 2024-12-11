package org.aktic.largestNumber;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static String largestNumber(int[] nums) {
        // Use a TreeMap to ensure keys are ordered
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();

        // Populate the map with digits as keys and numbers as values
        for (int num : nums) {
            int firstDigit = Integer.parseInt(String.valueOf(String.valueOf(num).charAt(0)));
            map.putIfAbsent(firstDigit, new ArrayList<>());
            map.get(firstDigit).add(num);
        }

        StringBuilder res = new StringBuilder();

        // Traverse the entry set in reverse order
        for (Map.Entry<Integer, ArrayList<Integer>> entry : ((TreeMap<Integer, ArrayList<Integer>>) map).descendingMap().entrySet()) {
            Integer[] tempArray = entry.getValue().toArray(new Integer[0]);

            // Custom sort: Compare concatenated strings to determine order
            Arrays.sort(tempArray, (a, b) -> {
                String order1 = String.valueOf(a) + b;
                String order2 = String.valueOf(b) + a;
                return order2.compareTo(order1); // Descending order
            });

            res.append(Arrays.stream(tempArray) // Convert array to stream
                    .map(String::valueOf)       // Convert each number to a String
                    .collect(Collectors.joining(""))); // Join them into a single string
        }

        // Handle edge case where all numbers are 0
        if (res.length() > 0 && res.charAt(0) == '0') {
            return "0";
        }

        return res.toString();
    }




    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{3,30,34,9,5}));
    }
}
