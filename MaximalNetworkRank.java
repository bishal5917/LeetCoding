import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MaximalNetworkRank {

    public int maximalNetworkRank(int n, int[][] roads) {
        int currMax = -1;
        // Lets create a graph with adjacency list first
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashSet<List<Integer>> givenPair = new HashSet<>();
        for (int[] road : roads) {
            givenPair.add(Arrays.asList(road[0], road[1]));
            if (graph.containsKey(road[0])) {
                List<Integer> neighbors = graph.get(road[0]);
                neighbors.add(road[1]);
                graph.put(road[0], neighbors);
            } else {
                List<Integer> neighbors = new ArrayList<>();
                neighbors.add(road[1]);
                graph.put(road[0], neighbors);
            }
            // FOR OPPOSITE SINCE THIS IS UNDIRECTED GRAPH
            if (graph.containsKey(road[1])) {
                List<Integer> neighbors = graph.get(road[1]);
                neighbors.add(road[0]);
                graph.put(road[1], neighbors);
            } else {
                List<Integer> neighbors = new ArrayList<>();
                neighbors.add(road[0]);
                graph.put(road[1], neighbors);
            }
        }
        System.out.println(graph);
        // Now count the edges for each and every pair
        int totalForPair = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i != j) {
                    // Check for every unequal nodes
                    int a = 0;
                    int b = 0;
                    if (graph.get(i) != null) {
                        a = graph.get(i).size();
                    }
                    if (graph.get(j) != null) {
                        b = graph.get(j).size();
                    }
                    totalForPair = a + b;
                    if (givenPair.contains(Arrays.asList(i, j)) || givenPair.contains(Arrays.asList(j, i))) {
                        totalForPair -= 1;
                    }
                    currMax = Math.max(totalForPair, currMax);
                }
            }
        }
        return currMax;
    }

    public static void main(String[] args) {
        MaximalNetworkRank obj = new MaximalNetworkRank();
        int n = 4;
        int[][] roads = { { 0, 1 }, { 0, 3 }, { 1, 2 }, { 1, 3 }, { 2, 3 }, { 2, 4 } };
        System.out.println(obj.maximalNetworkRank(n, roads));
    }
}
