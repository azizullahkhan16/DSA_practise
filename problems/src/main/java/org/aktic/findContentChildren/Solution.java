package org.aktic.findContentChildren;

import java.util.Arrays;

public class Solution {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int left = 0, right = 0;
        int content = 0;

        while(left < g.length && right < s.length) {
            if(g[left] <= s[right]) {
                content++;
                right++;
                left++;
            }else {
                right++;
            }
        }

        return content;

    }


    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[] {1,2,3}, new int[] {1,1}));
    }
}
