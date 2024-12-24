package org.aktic.findKthLargest;

import java.util.*;

public class Solution {
    public static int findKthLargest(int[] nums, int k) {
        List<Integer> r = new ArrayList<>();
        for(int n : nums)
            r.add(n);
        return quickSel(r,k);
    }

    public static int quickSel(List<Integer> r, int k){

        int p = r.get(new Random().nextInt(r.size()));

        List<Integer> sameAsP = new ArrayList<>();
        List<Integer> moreThanP = new ArrayList<>();
        List<Integer> lessThanP = new ArrayList<>();

        for(int n : r){
            if(n>p)
                moreThanP.add(n);
            else if(n<p)
                lessThanP.add(n);
            else
                sameAsP.add(n);
        }

        if(k<=moreThanP.size())
            return quickSel(moreThanP, k);
        else if(k>moreThanP.size()+sameAsP.size())
            return quickSel(lessThanP, k-moreThanP.size()-sameAsP.size());
        else
            return p;
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));
    }
}
