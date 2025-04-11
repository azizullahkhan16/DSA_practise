package org.aktic.countSymmetricIntegers;

public class Solution {
    public static int countSymmetricIntegers(int low, int high) {
        int count = 0;

        for (int i = low; i <= high; i++) {
            if (String.valueOf(i).length() % 2 != 0) continue;
            if (isValid(i)) count++;
        }

        return count;
    }

    public static boolean isValid(int num) {
        String temp = String.valueOf(num);
        int firstHalf = 0;
        int secondHalf = 0;
        for (int i = 0; i < temp.length() / 2; i++) {
            firstHalf += Character.getNumericValue(temp.charAt(i));
            secondHalf += Character.getNumericValue(temp.charAt(i + temp.length() / 2));
        }

        return firstHalf == secondHalf;
    }

    public static void main(String[] args) {
        System.out.println(isValid(2222));
    }
}
