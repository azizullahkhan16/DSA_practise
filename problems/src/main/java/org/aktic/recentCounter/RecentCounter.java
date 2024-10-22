package org.aktic.recentCounter;

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<Integer>();
    }

    public int ping(int t) {
        queue.add(t);
        int count = 0;
        for (Integer i : queue) {
            if (i >= t-3000) count++;
        }

        return count;
    }


    public static void main(String[] args) {
        RecentCounter rc = new RecentCounter();
        rc.ping(1);
        rc.ping(100);
        System.out.println(rc.ping(3001));
        rc.ping(3002);
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
