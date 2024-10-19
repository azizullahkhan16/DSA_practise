package org.aktic.maximumRepeatingSubstring;

class Solution {
    public static int maxRepeating(String sequence, String word) {
        return Math.max(maxRepeatingLeft(sequence, word), maxRepeatingRight(sequence, word));
    }
    public static int maxRepeatingLeft(String sequence, String word) {
        int maxRepeat = Integer.MIN_VALUE;
        int repeat = 0;

        int first;
        int second  = 0;

        char[] s = sequence.toCharArray();
        char[] q = word.toCharArray();

        for (first = 0; first < s.length; first++) {
            if(s[first] == q[second]) {
                second++;
            } else {
                repeat = 0;
                if(q[0] == s[first]) second = 1;
                else second = 0;
            }

            if(second == q.length) {
                repeat++;
                second = 0;
                maxRepeat = Math.max(maxRepeat, repeat);
            }


        }

        return maxRepeat == Integer.MIN_VALUE ? 0 : maxRepeat;

    }

    public static int maxRepeatingRight(String sequence, String word) {
        int maxRepeat = Integer.MIN_VALUE;
        int repeat = 0;

        int first;
        int second  = word.length()-1;

        char[] s = sequence.toCharArray();
        char[] q = word.toCharArray();

        for (first = s.length-1; first >= 0; first--) {
            if(s[first] == q[second]) {
                second--;
            } else {
                repeat = 0;
                second = word.length()-1;
            }

            if(second < 0) {
                repeat++;
                second = word.length()-1;
                maxRepeat = Math.max(maxRepeat, repeat);
            }


        }

        return maxRepeat == Integer.MIN_VALUE ? 0 : maxRepeat;

    }


    public static void main(String[] args) {
        String sequence = "aaabaaaabaaabaaaabaaaabaaaabaaaaba";
        String word = "aaaba";

        System.out.println(maxRepeating(sequence, word));
    }
}