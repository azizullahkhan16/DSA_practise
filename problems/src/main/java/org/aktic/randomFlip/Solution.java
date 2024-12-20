package org.aktic.randomFlip;

import java.util.*;

public class Solution {
    private Set<Integer> set;
    private int row;
    private int col;
    private Random rand;

    public Solution(int m, int n) {
        this.set = new HashSet<>();
        this.row = m;
        this.col = n;
        this.rand = new Random();
    }

    public int[] flip() {
        while(true) {
            int rand_index = rand.nextInt(row*col);
            if(!set.contains(rand_index)) {
                set.add(rand_index);
                return new int[]{rand_index/col, rand_index%col};

            }
        }


    }

    public void reset() {
        this.set.clear();
    }

    public static void main(String[] args) {
        Solution solution = new Solution(3, 4);
        System.out.println(Arrays.toString(solution.flip()));
        System.out.println(Arrays.toString(solution.flip()));
        System.out.println(Arrays.toString(solution.flip()));
        solution.reset();
    }
}
