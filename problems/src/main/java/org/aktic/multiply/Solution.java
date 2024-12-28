package org.aktic.multiply;

public class Solution {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int m = num1.length(), n = num2.length();
        int[] result = new int[m + n]; // Array to hold the result digits

        // Simulate multiplication
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + result[i + j + 1];

                result[i + j + 1] = sum % 10; // Place the unit digit
                result[i + j] += sum / 10;   // Carry the tens digit
            }
        }

        // Convert the result array to a string
        StringBuilder product = new StringBuilder();
        for (int num : result) {
            if (!(product.length() == 0 && num == 0)) { // Skip leading zeros
                product.append(num);
            }
        }

        return product.toString();
    }



    public static void main(String[] args) {
    }
}
