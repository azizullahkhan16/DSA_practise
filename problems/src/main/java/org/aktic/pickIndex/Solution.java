package org.aktic.pickIndex;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    private double sum;
    private int[] arr;
    private double[] prob;
    public Solution(int[] w) {
        this.arr = w;
        for(int num: w) {
            this.sum += num;
        }

        prob = new double[arr.length];

        for (int i = 0; i < this.arr.length; i++) {
            prob[i] = (double)this.arr[i] / (double)this.sum;
        }

        Arrays.sort(prob);
    }

    public int pickIndex() {
        Random rand = new Random();
        double index = rand.nextDouble();

        for (int i = 0; i < this.arr.length; i++) {
            if(index < prob[i]) return i;
        }

        return arr.length - 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3};
        Solution solution = new Solution(nums);
        System.out.println(solution.pickIndex());
    }
}
