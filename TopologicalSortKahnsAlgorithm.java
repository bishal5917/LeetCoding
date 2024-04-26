import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortKahnsAlgorithm {

    // THIS WORKS FOR DAG Only (Directed Acyclic Graph)
    public List<Integer> topologicalOrdering(int[][] graph) {
        List<Integer> ordering = new ArrayList<>();
        int[] indegree = new int[graph.length];
        // Here we calculate the indegrees for all the vertices
        for (int[] adjacencies : graph) {
            for (int node : adjacencies) {
                indegree[node] += 1;
            }
        }
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                topoSortBfsHelper(graph, indegree, ordering, i);
            }
        }
        return ordering;
    }

    private void topoSortBfsHelper(int[][] graph, int[] indegree, List<Integer> order, int curr) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(curr);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);
            // marking as visited by -1
            indegree[node] = -1;
            // Now cancel the current node and all edges going from it
            for (int child : graph[node]) {
                indegree[child] -= 1;
                if (indegree[child] == 0) {
                    queue.offer(child);
                }
            }
        }
    }

    public static void main(String[] args) {
        TopologicalSortKahnsAlgorithm obj = new TopologicalSortKahnsAlgorithm();
        // int[][] adjacencies = {
        // {}, { 0 }, { 1 }, { 1 }, {}, { 2, 4 }, { 4, 3 }, { 5, 6 }
        // };
        int[][] adjacencies = {
                { 5, 2 }, { 3, 6 }, { 4 }, { 5 }, {}, { 2, 4 }, { 2 }
        };
        System.out.println(obj.topologicalOrdering(adjacencies));
    }
}
