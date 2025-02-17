package org.aktic.Devyatkino;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt();
            System.out.println(findMinOperations(n));
        }

        scanner.close();
    }

    private static int findMinOperations(int n) {
        if (containsSeven(n)) return 0; // Already contains 7

        int addend = 9, operations = 1;
        while (true) {
            if (containsSeven(n + addend)) return operations;
            addend = addend * 10 + 9; // Generate next number like 9, 99, 999, etc.
            operations++;
        }
    }

    private static boolean containsSeven(int number) {
        while (number > 0) {
            if (number % 10 == 7) return true;
            number /= 10;
        }
        return false;
    }
}
