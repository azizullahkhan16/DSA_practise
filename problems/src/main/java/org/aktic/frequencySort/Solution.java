package org.aktic.frequencySort;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Object[]> priorityQueue = new PriorityQueue<>((a, b) -> (int)b[1] - (int)a[1]);

        for(Character c: map.keySet()) {
            priorityQueue.add(new Object[] {c, map.get(c)});
        }

        String res = "";

        while (!priorityQueue.isEmpty()) {
            Object[] bucket = priorityQueue.poll();
            char value = (char) bucket[0];
            int countC = (int) bucket[1];
            for (int i = countC; i > 0; i--) {
                res += value;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
}
