import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReachableNodesWithRestrictions {

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
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
        HashSet<Integer> restrictions = new HashSet<>();
        for (int resNode : restricted) {
            restrictions.add(resNode);
        }
        // LETS USE THE BREADTH FIRST SEARCH APPROACH TO COUNT THE NUMBER OF THE NODES
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (visited.contains(curr) || restrictions.contains(curr)) {
                continue;
            }
            visited.add(curr);
            if (graph.get(curr) == null) {
                continue;
            }
            // else take all its unvisited and unrestricted neighbors and add them to the
            // queue
            List<Integer> neighbors = graph.get(curr);
            for (int neighbor : neighbors) {
                if (visited.contains(neighbor) || restrictions.contains(neighbor)) {
                    continue;
                }
                queue.offer(neighbor);
            }
        }
        System.out.println(graph);
        return visited.size();
    }

    public static void main(String[] args) {
        ReachableNodesWithRestrictions obj = new ReachableNodesWithRestrictions();
        int n = 7;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 3, 1 }, { 4, 0 }, { 0, 5 }, { 5, 6 } };
        int[] restricted = { 4, 5 };
        System.out.println(obj.reachableNodes(n, edges, restricted));
    }
}
