package org.aktic.floodFill;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        Queue<Integer[]> queue = new LinkedList<>();

        queue.add(new Integer[]{sr, sc});
        int original = image[sr][sc];

        while (!queue.isEmpty()) {
            Integer[] pos = queue.poll();
            image[pos[0]][pos[1]] = color;

            if(pos[1]-1 >= 0 && original == image[pos[0]][pos[1]-1]) {
                queue.add(new Integer[]{pos[0],pos[1]-1});
            }

            if(pos[1]+1 < image[0].length && original == image[pos[0]][pos[1]+1]) {
                queue.add(new Integer[]{pos[0],pos[1]+1});
            }

            if(pos[0]-1 >= 0 && original == image[pos[0]-1][pos[1]]) {
                queue.add(new Integer[]{pos[0]-1,pos[1]});
            }

            if(pos[0]+1 < image.length && original == image[pos[0]+1][pos[1]]) {
                queue.add(new Integer[]{pos[0]+1,pos[1]});
            }

        }

        return image;
    }

    public static void main(String[] args) {
        int[][] image = {{0, 0, 0},{0, 0, 0}};
        print2DArray(floodFill(image, 0, 0, 0));
    }

    public static void print2DArray(int[][] array) {
        for (int i = 0; i < array.length; i++) { // Loop over rows
            for (int j = 0; j < array[i].length; j++) { // Loop over columns
                System.out.print(array[i][j] + " "); // Print element
            }
            System.out.println(); // Move to the next line after each row
        }
    }


}
