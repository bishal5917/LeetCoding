import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class TopologicalSorting {

    // THIS WORKS FOR DAG Only (Directed Acyclic Graph)
    public List<Integer> topologicalOrdering(int[][] graph) {
        List<Integer> ordering = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        // We run DFS topoplogical ordering for all unvisited nodes
        for (int i = 0; i < graph.length; i++) {
            if (visited.contains(i)) {
                continue;
            }
            topoSortDfsHelper(graph, visited, ordering, i);
            visited.add(i);
            ordering.add(i);
        }
        Collections.reverse(ordering);
        return ordering;
    }

    private void topoSortDfsHelper(int[][] graph, HashSet<Integer> visited, List<Integer> order, int curr) {
        if (graph[curr].length == 0) {
            // means no other outgoing edges
            // we return
            return;
        }
        // Run dfs for all its current adjacencies
        for (int child : graph[curr]) {
            if (!visited.contains(child)) {
                topoSortDfsHelper(graph, visited, order, child);
                visited.add(child);
                order.add(child);
            }
        }
    }

    public static void main(String[] args) {
        TopologicalSorting obj = new TopologicalSorting();
        // int[][] adjacencies = {
        // {}, { 0 }, { 1 }, { 1 }, {}, { 2, 4 }, { 4, 3 }, { 5, 6 }
        // };
        // int[][] adjacencies = {
        // {}, {}, { 3 }, { 1 }, { 0, 1 }, { 2, 0 }
        // };
        int[][] adjacencies = {
                { 5, 2 }, { 3, 6 }, { 4 }, { 5 }, {}, { 2, 4 }, { 2 }
        };
        System.out.println(obj.topologicalOrdering(adjacencies));
    }
}
