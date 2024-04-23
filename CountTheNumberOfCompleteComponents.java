import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CountTheNumberOfCompleteComponents {

    public int countCompleteComponents(int n, int[][] edges) {
        int count = 0;
        // Lets create an adjacency list
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            if (graph.containsKey(edge[0])) {
                List<Integer> neighbors = graph.get(edge[0]);
                neighbors.add(edge[1]);
                graph.put(edge[0], neighbors);
            } else {
                List<Integer> neighbors = new ArrayList<>();
                neighbors.add(edge[1]);
                graph.put(edge[0], neighbors);
            }
            // NOW DO THIS FOR OPPOSITE
            if (graph.containsKey(edge[1])) {
                List<Integer> neighbors = graph.get(edge[1]);
                neighbors.add(edge[0]);
                graph.put(edge[1], neighbors);
            } else {
                List<Integer> neighbors = new ArrayList<>();
                neighbors.add(edge[0]);
                graph.put(edge[1], neighbors);
            }
        }
        System.out.println(graph);
        // Now doing dfs to find the number of components
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            // perform bfs
            if (visited.contains(i)) {
                continue;
            }
            // PERFORM DFS NOW
            // COUNTING VERTICES AND EDGES FOR EACH CONNECTED COMPONENTS
            int[] counts = dfsHelper(graph, visited, new HashSet<>(), i, new int[] { 0, 0 });
            int v = counts[0];
            int e = counts[1];
            if (e == (v * (v - 1) / 2)) {
                count += 1;
            }
        }
        return count;
    }

    private int[] dfsHelper(HashMap<Integer, List<Integer>> graph, HashSet<Integer> visited,
            HashSet<List<Integer>> visitedEdges, int curr, int[] counts) {
        if (visited.contains(curr)) {
            return counts;
        }
        if (graph.get(curr) == null) {
            counts[0] += 1;
            return counts;
        }
        visited.add(curr);
        counts[0] += 1;
        for (int neighbor : graph.get(curr)) {
            // Now for edges
            if (!visitedEdges.contains(Arrays.asList(curr, neighbor))
                    && !visitedEdges.contains(Arrays.asList(neighbor, curr))) {
                counts[1] += 1;
            }
            visitedEdges.add(Arrays.asList(curr, neighbor));
            counts = dfsHelper(graph, visited, visitedEdges, neighbor, counts);
        }
        return counts;
    }

    public static void main(String[] args) {
        CountTheNumberOfCompleteComponents obj = new CountTheNumberOfCompleteComponents();
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 3, 4 } };
        int n = 6;
        System.out.println(obj.countCompleteComponents(n, edges));
    }
}