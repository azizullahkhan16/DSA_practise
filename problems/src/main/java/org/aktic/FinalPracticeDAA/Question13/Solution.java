package org.aktic.FinalPracticeDAA.Question13;

import java.util.*;

public class Solution {
    // A helper class to represent an element from a list
    static class ArrayElement {
        int value;          // Value of the element
        int arrayIndex;     // Index of the array the element belongs to
        int elementIndex;   // Index of the element within the array

        // Constructor to initialize the element details
        ArrayElement(int value, int arrayIndex, int elementIndex) {
            this.value = value;
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }
    }

    // Method to merge multiple sorted lists into a single sorted list
    public static List<Integer> merge(List<List<Integer>> lists) {
        // Min-heap to store the smallest current elements from each list
        PriorityQueue<ArrayElement> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.value));
        List<Integer> result = new ArrayList<>(); // Final merged result list

        // Step 1: Add the first element of each list to the min-heap
        for (int i = 0; i < lists.size(); i++) { // Loop over all the input lists
            if (!lists.get(i).isEmpty()) { // Check if the list is not empty
                // Add the first element of the list into the heap
                minHeap.add(new ArrayElement(lists.get(i).get(0), i, 0));
            }
        }

        // Step 2: Extract the smallest element from the heap until it is empty
        while (!minHeap.isEmpty()) {
            // Poll (remove) the smallest element from the heap
            ArrayElement current = minHeap.poll();

            // Add the smallest element's value to the result list
            result.add(current.value);

            // Step 3: Insert the next element from the same list into the heap
            List<Integer> currentList = lists.get(current.arrayIndex); // Get the list of the current element
            int nextIndex = current.elementIndex + 1; // Index of the next element in the list

            if (nextIndex < currentList.size()) { // Check if there are more elements in the list
                // Add the next element from the same list into the heap
                minHeap.add(new ArrayElement(currentList.get(nextIndex), current.arrayIndex, nextIndex));
            }
        }

        // Step 4: Return the fully merged sorted list
        return result;
    }

    public static void main(String[] args) {
        // Input: A list of sorted lists
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(1, 4, 7)); // First sorted list
        lists.add(Arrays.asList(2, 5, 8)); // Second sorted list
        lists.add(Arrays.asList(3, 6, 9)); // Third sorted list

        // Call the merge method and print the merged result
        List<Integer> mergedList = merge(lists);
        System.out.println("Merged List: " + mergedList);
    }
}
