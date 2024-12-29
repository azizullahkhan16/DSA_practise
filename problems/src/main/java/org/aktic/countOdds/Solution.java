package org.aktic.countOdds;

public class Solution {
    public static int countOdds(int low, int high) {
        if(low%2 == 0 && high%2 == 0) {
            if(high-low == 2) return 0;
            else return (high-low)/2;
        }else if(low%2 == 1 && high%2 == 1) {
            if(high-low == 2) return 2;
            else return (high-low)/2+1;
        }else {
            if(high-low == 1) return 1;
            else return (high-low)/2+1;
        }
    }

    public static void main(String[] args) {

    }
}
