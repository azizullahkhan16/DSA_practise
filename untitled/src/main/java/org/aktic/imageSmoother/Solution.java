package org.aktic.imageSmoother;

import java.util.Arrays;

public class Solution {
    public static int[][] imageSmoother(int[][] img) {
        int sum = 0;
        int count = 0;
        int[][] result = new int[img.length][img[0].length];

        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                // anti-clockwise rotation
                if(i - 1 >= 0 && j - 1 >= 0) {
                    sum += img[i-1][j-1];
                    count++;
                }
                if(i - 1 >= 0) {
                    sum += img[i-1][j];
                    count++;
                }
                if(i-1 >= 0 && j+1 < img[i].length) {
                    sum += img[i-1][j+1];
                    count++;
                }
                if(j+1 < img[i].length) {
                    sum += img[i][j+1];
                    count++;
                }
                if(i+1 < img.length && j+1 < img[i].length) {
                    sum += img[i+1][j+1];
                    count++;
                }
                if(i+1 < img.length) {
                    sum += img[i+1][j];
                    count++;
                }
                if(j - 1 >= 0 && i + 1 < img.length) {
                    sum += img[i+1][j-1];
                    count++;
                }
                if(j - 1 >= 0) {
                    sum += img[i][j-1];
                    count++;
                }
                result[i][j] = (sum + img[i][j])/(count+1);
                sum = 0;
                count = 0;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[][] img = {{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};
        System.out.println(Arrays.deepToString(imageSmoother(img)));
    }
}
