import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CountUnreachablePairsOfNode {

    public long countPairs(int n, int[][] edges) {
        long count = 0;
        long total = n;
        // Lets create an adjacency list first
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
            // FOR OPPOSITE SINCE THIS IS UNDIRECTED GRAPH
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
        // Now Running DFS to find the connected components size
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) {
                continue;
            }
            long size = dfsHelper(graph, visited, i, 0);
            total = total - size;
            count += size * total;
        }
        return count;
    }

    private long dfsHelper(HashMap<Integer, List<Integer>> graph, HashSet<Integer> visited, int curr, long count) {
        if (visited.contains(curr)) {
            return count;
        }
        if (graph.get(curr) == null) {
            return count + 1;
        }
        count += 1;
        visited.add(curr);
        // Now run dfs for its all neighbors
        for (int node : graph.get(curr)) {
            count = dfsHelper(graph, visited, node, count);
        }
        return count;
    }

    public static void main(String[] args) {
        CountUnreachablePairsOfNode obj = new CountUnreachablePairsOfNode();
        int[][] edges = { { 0, 2 }, { 0, 5 }, { 2, 4 }, { 1, 6 }, { 5, 4 } };
        int n = 7;
        System.out.println(obj.countPairs(n, edges));
    }
}
