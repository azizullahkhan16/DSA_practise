package org.aktic.minTimeToReach;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    static class Cell {
        int x, y, cost;

        Cell(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public static int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;

        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dist[0][0] = moveTime[0][0];

        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.offer(new Cell(0, 0, 0));

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            int x = cell.x, y = cell.y, currCost = cell.cost;

            if (x == m - 1 && y == n - 1) {
                return currCost;
            }

            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    int newCost;
                    if (currCost >= moveTime[nx][ny]) newCost = currCost + 1;
                    else newCost = moveTime[nx][ny] + 1;

                    if (newCost < dist[nx][ny]) {
                        dist[nx][ny] = newCost;
                        pq.offer(new Cell(nx, ny, newCost));
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(minTimeToReach(new int[][]{{0, 4}, {4, 4}}));
    }
}
