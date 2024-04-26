import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllAncestorsOfNodeInDAG {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<HashSet<Integer>> ancestors = new ArrayList<>();
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            ancestors.add(new HashSet<>());
        }
        // Lets create a reversed DAG first
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(to);
            indegree[to] += 1;
        }
        // System.out.println(graph);
        // gotta run BFS for nodes with indegree 0
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                topoSortBfsHelper(graph, indegree, ancestors, i);
            }
        }
        // Now time to remove duplicates from ancestors,sort them and return
        // Now sort the ancestors and return
        List<List<Integer>> allAncestors = new ArrayList<>();
        for (HashSet<Integer> ancestor : ancestors) {
            List<Integer> ances = new ArrayList<>(ancestor);
            Collections.sort(ances);
            allAncestors.add(ances);
        }
        return allAncestors;
    }

    private void topoSortBfsHelper(HashMap<Integer, List<Integer>> graph, int[] indegree,
            List<HashSet<Integer>> ancestors,
            int curr) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(curr);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            // marking as visited by -1
            indegree[node] = -1;
            // Now cancel the current node and all edges going from it
            if (graph.get(node) == null) {
                continue;
            }
            for (int child : graph.get(node)) {
                ancestors.get(child).add(node);
                ancestors.get(child).addAll(ancestors.get(node));
                indegree[child] -= 1;
                if (indegree[child] == 0) {
                    queue.offer(child);
                }
            }
        }
    }

    public static void main(String[] args) {
        AllAncestorsOfNodeInDAG obj = new AllAncestorsOfNodeInDAG();
        int n = 8;
        int[][] edges = { { 0, 3 }, { 0, 4 }, { 1, 3 }, { 2, 4 }, { 2, 7 }, { 3, 5 }, { 3, 6 }, { 3, 7 }, { 4, 6 } };
        System.out.println(obj.getAncestors(n, edges));
    }
}
