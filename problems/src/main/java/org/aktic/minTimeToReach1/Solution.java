package org.aktic.minTimeToReach1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    static class Cell {
        int x, y, time, moves;

        Cell(int x, int y, int time, int moves) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.moves = moves;
        }
    }

    public static int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;

        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
        pq.offer(new Cell(0, 0, 0, 0));
        dist[0][0] = 0;

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            int x = cell.x, y = cell.y, time = cell.time, moves = cell.moves;

            if (x == m - 1 && y == n - 1) return time;

            int moveCost = (moves % 2 == 0) ? 1 : 2;

            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    int waitTime = Math.max(time + moveCost, moveTime[nx][ny]);
                    if (waitTime < dist[nx][ny]) {
                        dist[nx][ny] = waitTime;
                        pq.offer(new Cell(nx, ny, waitTime, moves + 1));
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(minTimeToReach(new int[][]{{0, 0, 0, 0}, {0, 0, 0, 0}}));
    }
}
