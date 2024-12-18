package org.aktic.rand10;

public class Solution {
    private static int rand7() {
        return (int) (Math.random() * 7);
    }

    public int rand10() {
        while (true) {
            int num = (rand7() - 1) * 7 + rand7();

            if (num <= 40) {
                return (num - 1) % 10 + 1;
            }
        }
    }
}
