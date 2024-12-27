package org.aktic.isRobotBounded;

public class Solution {
    public static boolean isRobotBounded(String instructions) {
        // Directions: North (0,1), East (1,0), South (0,-1), West (-1,0)
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0;
        int dir = 0;

        for (char c : instructions.toCharArray()) {
            if (c == 'G') {
                x += directions[dir][0];
                y += directions[dir][1];
            } else if (c == 'L') {
                dir = (dir + 3) % 4;
            } else if (c == 'R') {
                dir = (dir + 1) % 4;
            }
        }

        return (x == 0 && y == 0) || dir != 0;
    }

    public static void main(String[] args) {
        System.out.println(isRobotBounded("GGLLGG"));
    }
}
