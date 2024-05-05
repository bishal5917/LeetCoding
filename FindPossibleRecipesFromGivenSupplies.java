import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindPossibleRecipesFromGivenSupplies {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> ans = new ArrayList<>();
        HashSet<String> supplySet = new HashSet<>();
        for (String supply : supplies) {
            supplySet.add(supply);
        }
        HashMap<String, List<String>> graph = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            graph.put(recipe, ingredients.get(i));
        }
        System.out.println(graph);
        // Now we run DFS on the ingredients one by one and check if we can make them
        List<String> cantMake = new ArrayList<>();
        for (String recipe : recipes) {
            boolean canMake = canMakeDfsHelper(graph, supplySet, recipe, new HashSet<>(), true);
            if (canMake) {
                supplySet.add(recipe);
            } else {
                cantMake.add(recipe);
            }
        }
        // This is a bad approach,we should sort based on indegrees
        // Now check again if we can make now
        for (String recipe : cantMake) {
            boolean canMake = canMakeDfsHelper(graph, supplySet, recipe, new HashSet<>(), true);
            if (canMake) {
                supplySet.add(recipe);
            }
        }
        // Now add those recipes to ans that are also supplies
        for (String recipe : recipes) {
            if (supplySet.contains(recipe)) {
                ans.add(recipe);
            }
        }
        return ans;
    }

    private boolean canMakeDfsHelper(HashMap<String, List<String>> graph, HashSet<String> supplies, String curr,
            HashSet<String> visiting, boolean canMake) {
        if (visiting.contains(curr)) {
            canMake = false;
            return canMake;
        }
        if (supplies.contains(curr)) {
            return canMake;
        }
        if (graph.get(curr) == null) {
            if (!supplies.contains(curr)) {
                canMake = false;
            }
            return canMake;
        }
        visiting.add(curr);
        // go for all its ingredients
        for (String ings : graph.get(curr)) {
            canMake = canMakeDfsHelper(graph, supplies, ings, visiting, canMake);
            if (canMake == false) {
                return false;
            }
        }
        return canMake;
    }

    public static void main(String[] args) {
        FindPossibleRecipesFromGivenSupplies obj = new FindPossibleRecipesFromGivenSupplies();
        String[] recipes = { "burger", "bread", "sandwich" };
        String[] supplies = { "yeast", "flour", "meat" };
        List<List<String>> ingredients = new ArrayList<>();
        ingredients.add(Arrays.asList("sandwich", "meat", "bread"));
        ingredients.add(Arrays.asList("yeast", "flour"));
        ingredients.add(Arrays.asList("meat", "bread"));
        System.out.println(obj.findAllRecipes(recipes, ingredients, supplies));
    }
}
