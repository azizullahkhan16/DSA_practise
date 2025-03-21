package org.aktic.findAllRecipes;

import java.util.*;

public class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Integer> inDegree = new HashMap<>(); // Track missing ingredients for each recipe
        Map<String, List<String>> graph = new HashMap<>(); // Ingredient → Recipes it helps create

        // Step 1: Build the graph
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            inDegree.put(recipe, ingredients.get(i).size()); // Count required ingredients

            for (String ing : ingredients.get(i)) {
                graph.putIfAbsent(ing, new ArrayList<>());
                graph.get(ing).add(recipe); // Ingredient contributes to this recipe
            }
        }

        // Step 2: Initialize queue with available ingredients
        Queue<String> queue = new LinkedList<>();
        Set<String> available = new HashSet<>(Arrays.asList(supplies));

        for (String supply : supplies) {
            queue.add(supply);
        }

        List<String> result = new ArrayList<>();

        // Step 3: Process the queue
        while (!queue.isEmpty()) {
            String ingredient = queue.poll();

            if (!graph.containsKey(ingredient)) continue; // No recipes depend on this ingredient

            for (String recipe : graph.get(ingredient)) {
                inDegree.put(recipe, inDegree.get(recipe) - 1);

                if (inDegree.get(recipe) == 0) { // All ingredients available
                    queue.add(recipe);
                    result.add(recipe);
                }
            }
        }

        return result;
    }
}
