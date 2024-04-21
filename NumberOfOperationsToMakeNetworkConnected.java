import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class NumberOfOperationsToMakeNetworkConnected {

    public int makeConnected(int n, int[][] connections) {
        int count = 0;
        // Lets create an adjacency list
        HashMap<Integer, List<Integer>> nodes = new HashMap<>();
        for (int[] edge : connections) {
            if (nodes.containsKey(edge[0])) {
                List<Integer> neighbors = nodes.get(edge[0]);
                neighbors.add(edge[1]);
                nodes.put(edge[0], neighbors);
            } else {
                List<Integer> neighbors = new ArrayList<>();
                neighbors.add(edge[1]);
                nodes.put(edge[0], neighbors);
            }
            // FOR OPPOSITE SINCE THIS IS UNDIRECTED GRAPH
            if (nodes.containsKey(edge[1])) {
                List<Integer> neighbors = nodes.get(edge[1]);
                neighbors.add(edge[0]);
                nodes.put(edge[1], neighbors);
            } else {
                List<Integer> neighbors = new ArrayList<>();
                neighbors.add(edge[0]);
                nodes.put(edge[1], neighbors);
            }
        }
        System.out.println(nodes);
        // Now doing dfs to find the number of components
        HashSet<Integer> visited = new HashSet<>();
        int totalEdges = 0;
        for (int i = 0; i < n; i++) {
            // perform bfs
            if (visited.contains(i)) {
                continue;
            }
            count += 1;
            // PERFORM DFS NOW
            int val = dfsHelper(nodes, visited, new HashSet<>(), i, 0);
            totalEdges += val;
        }
        // THERE MUST BE AT LEAST N-1 EDGES
        return totalEdges >= n - 1 ? count - 1 : -1;
    }

    private int dfsHelper(HashMap<Integer, List<Integer>> nodes, HashSet<Integer> visited,
            HashSet<List<Integer>> visitedEdge, int curr, int edges) {
        // Go for all of its neighbors
        if (nodes.get(curr) == null || visited.contains(curr)) {
            return edges;
        }
        visited.add(curr);
        List<Integer> neighbors = nodes.get(curr);
        for (int neighbor : neighbors) {
            if (!visitedEdge.contains(Arrays.asList(curr, neighbor))
                    && !visitedEdge.contains(Arrays.asList(neighbor, curr))) {
                edges += 1;
            }
            visitedEdge.add(Arrays.asList(curr, neighbor));
            edges = dfsHelper(nodes, visited, visitedEdge, neighbor, edges);
        }
        return edges;
    }

    public static void main(String[] args) {
        NumberOfOperationsToMakeNetworkConnected obj = new NumberOfOperationsToMakeNetworkConnected();
        int n = 6;
        int[][] connections = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 } };
        System.out.println(obj.makeConnected(n, connections));
    }
}
