package org.aktic.NumberContainers;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class NumberContainers {

    private Map<Integer, Integer> map; // Stores index -> number
    private Map<Integer, PriorityQueue<Integer>> indexes; // Stores number -> min-heap of indices

    public NumberContainers() {
        this.map = new HashMap<>();
        this.indexes = new HashMap<>();
    }

    public void change(int index, int number) {
        if (map.containsKey(index)) {
            int oldNumber = map.get(index);

            // Remove index from old number's queue
            PriorityQueue<Integer> oldQueue = indexes.get(oldNumber);
            oldQueue.remove(index);
            if (oldQueue.isEmpty()) {
                indexes.remove(oldNumber); // Remove empty queue
            }
        }

        // Add index to new number's queue
        indexes.computeIfAbsent(number, k -> new PriorityQueue<>()).add(index);
        map.put(index, number);
    }

    public int find(int number) {
        PriorityQueue<Integer> queue = indexes.get(number);
        return (queue == null || queue.isEmpty()) ? -1 : queue.peek();
    }

    public static void main(String[] args) {
        NumberContainers numberContainers = new NumberContainers();
        numberContainers.find(10);
        numberContainers.change(2, 10);
        numberContainers.change(1, 10);
        numberContainers.change(3, 10);
        numberContainers.change(5, 10);
        numberContainers.find(10);
        numberContainers.change(1, 20);
        numberContainers.find(10);
    }
}