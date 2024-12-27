package org.aktic.judgeCircle;

public class Solution {
    public static boolean judgeCircle(String moves) {
        int[] pos = new int[2];

        for(char c : moves.toCharArray() ) {
            switch(c) {
                case 'U':
                    pos[1]++;
                    break;
                case 'D':
                    pos[1]--;
                    break;
                case 'L':
                    pos[0]--;
                    break;
                case 'R':
                    pos[0]++;
                    break;
                default:
                    return false;
            }
        }

        return pos[0] == 0 && pos[1] == 0;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
