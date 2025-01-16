package org.aktic.countStudents;

public class Solution {
    public static int countStudents(int[] students, int[] sandwiches) {
        int countZeros = 0;
        int countOnes = 0;

        for (int student : students) {
            if (student == 0) {
                countZeros++;
            } else {
                countOnes++;
            }
        }

        // Process the sandwiches
        for (int sandwich : sandwiches) {
            if (sandwich == 0) {
                if (countZeros > 0) {
                    countZeros--;
                } else {
                    return countZeros + countOnes;
                }
            } else {
                if (countOnes > 0) {
                    countOnes--;
                } else {
                    return countZeros + countOnes;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(countStudents(new int[] {1,1,0,0}, new int[] {0,1,0,1}));
    }
}
