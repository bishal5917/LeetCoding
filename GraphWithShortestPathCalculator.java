import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class GraphWithShortestPathCalculator {

    HashMap<Integer, List<int[]>> graph;

    public GraphWithShortestPathCalculator(int n, int[][] edges) {
        this.graph = new HashMap<>();
        // Lets create an adjacency list
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(new int[] { edge[1], edge[2] });
        }
    }

    public void addEdge(int[] edge) {
        // just add a new edge in adjacency list
        graph.putIfAbsent(edge[0], new ArrayList<>());
        graph.get(edge[0]).add(new int[] { edge[1], edge[2] });
    }

    public int shortestPath(int node1, int node2) {
        return dijkstraHelper(node1, node2);
    }

    private int dijkstraHelper(int start, int end) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] - b[1]);
        HashSet<Integer> visited = new HashSet<>();
        pq.offer(new int[] { start, 0 });
        // Then performing bfs
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[0] == end) {
                // if destination found return cost
                return curr[1];
            }
            if (visited.contains(curr[0])) {
                continue;
            }
            visited.add(curr[0]);
            // else we go for all neighbors
            if (graph.get(curr[0]) == null) {
                continue;
            }
            for (int[] neighbour : graph.get(curr[0])) {
                // add to pq updating the costs
                pq.offer(new int[] { neighbour[0], curr[1] + neighbour[1] });
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] edges = {
                { 0, 2, 5 }, { 0, 1, 2 }, { 1, 2, 1 }, { 3, 0, 3 }
        };
        GraphWithShortestPathCalculator obj = new GraphWithShortestPathCalculator(4, edges);
        System.out.println(obj.shortestPath(3, 2));
        System.out.println(obj.shortestPath(0, 3));
        obj.addEdge(new int[] { 1, 3, 4 });
        System.out.println(obj.shortestPath(0, 3));
    }
}
