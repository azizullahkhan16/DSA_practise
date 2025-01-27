package org.aktic.memLeak;

import java.util.Arrays;

public class Solution {
    public static int[] memLeak(int memory1, int memory2) {
        int[] res = new int[3];
        int count = 1;

        while(true) {
            if(memory1 >= memory2) {
                if(memory1 >= count) memory1 -= count;
                else break;
            }else {
                if(memory2 >= count) memory2 -= count;
                else break;
            }
            count++;
        }

        return new int[] {count, memory1, memory2};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(memLeak(2, 2)));
    }
}
