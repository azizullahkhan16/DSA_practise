package org.aktic.checkStraightLine;

public class Solution {
    public static boolean checkStraightLine(int[][] coordinates) {
        double gradient;
        if(coordinates[0][0] == 0 && coordinates[1][0] == 0) gradient = 0;
        else gradient = (double) (coordinates[0][1] - coordinates[1][1]) /(coordinates[0][0]-coordinates[1][0]);

        for (int i = 2; i < coordinates.length; i++) {
            double temp;
            if(coordinates[i-1][0] == 0 && coordinates[i][0] == 0) temp = 0;
            else temp = (double) (coordinates[i-1][1] - coordinates[i][1]) /(coordinates[i-1][0]-coordinates[i][0]);
            if(temp != gradient) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkStraightLine(new int[][] {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}}));
    }
}
