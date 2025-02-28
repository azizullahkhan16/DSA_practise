package org.aktic.interview;

import java.util.*;

public class Solution {

    public static int secondHighest(int[] arr) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > first) {
                if (second != Integer.MIN_VALUE && first != arr[i]) second = first;
                first = i;
            } else if (arr[i] > second && first != arr[i]) {
                second = i;
            }
        }

        return second == Integer.MIN_VALUE ? -1 : second;
    }


//    private static String commonPrefix(String[] arr) {
//        String prefix = arr[]
//    }

    public static List<Integer> performOperations(List<Integer> arr, List<List<Integer>> operations) {
        // Write your code here
        for (List<Integer> op : operations) {
            int leftIndex = op.get(0);
            int rightIndex = op.get(1);

            while (leftIndex < rightIndex) {
                int temp = arr.get(leftIndex);
                arr.remove(leftIndex);
                arr.add(leftIndex, arr.get(rightIndex));
                arr.remove(rightIndex);
                arr.add(rightIndex, temp);
                leftIndex++;
                rightIndex--;
            }

        }

        return arr;

    }

    public static long getMinimumValue(List<Integer> power, int armor) {
        // Write your code here
        long damage = 1;
        int maxDamageIndex = -1;
        int maxDamage = -1;

        for (int i = 0; i < power.size(); i++) {
            if (maxDamage < power.get(i)) {
                maxDamage = power.get(i);
                maxDamageIndex = i;
            }
        }

        for (int i = 0; i < power.size(); i++) {
            if (i == maxDamageIndex) {
                damage += Math.min(armor, power.get(i));
            } else {
                damage += power.get(i);
            }
        }

        return damage;

    }


    public static void main(String[] args) {
//        System.out.println(secondHighest(new int[]{-3, 2, 1, -3}));
//        System.out.println(secondHighest(new int[]{0, 0, 1, 1, 2, 2}));
//        System.out.println(secondHighest(new int[]{5, -1, -3, 0, 2, 2}));
//        System.out.println(secondHighest(new int[]{5, 5, 5, 5}));
//        System.out.println(secondHighest(new int[]{0, -1, 2, 2, 2, 3, 3}));
//        System.out.println(secondHighest(new int[]{0, -1, -1, 5, 5, 4, 4}));
//        System.out.println(secondHighest(new int[]{1, 3, 4, 2, 5, 4, 8, 5, 4, 3, 7, 0}));

//        List<List<Integer>> list = new ArrayList<>();
//        list.add(Arrays.asList(0, 4));
//        List<Integer> res = new ArrayList<>();
//        res.add(9);
//        res.add(8);
//        res.add(7);
//        res.add(6);
//        res.add(4);
//
//        System.out.println(performOperations(res, list));

        System.out.println(getMinimumValue(Arrays.asList(3, 1, 2, 3), 1));
    }
}
