import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindEdgesInShortestPaths {

    public boolean[] findAnswer(int n, int[][] edges) {
        boolean[] ans = new boolean[edges.length];
        int[] dist = new int[n];
        HashSet<List<Integer>> finalEdges = new HashSet<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        // creating an adjacency list
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.get(a).add(new int[] { b, cost });
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(b).add(new int[] { a, cost });
        }
        dijkstraHelper(graph, dist);
        System.out.println(Arrays.toString(dist));
        bfsHelper(graph, dist, finalEdges);
        System.out.println(finalEdges);
        // Now time to check the edges if they are present
        for (int i = 0; i < edges.length; i++) {
            int[] curr = edges[i];
            if (finalEdges.contains(Arrays.asList(curr[0], curr[1]))) {
                ans[i] = true;
            }
        }
        return ans;
    }

    private void dijkstraHelper(HashMap<Integer, List<int[]>> graph, int[] dist) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] - b[1]);
        HashSet<Integer> visited = new HashSet<>();
        pq.offer(new int[] { 0, 0 });
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (visited.contains(curr[0])) {
                continue;
            }
            visited.add(curr[0]);
            if (curr[0] == dist.length - 1) {
                // means reached last node
                return;
            }
            // we for for all its neighbors
            if (graph.get(curr[0]) == null) {
                continue;
            }
            for (int[] next : graph.get(curr[0])) {
                if (visited.contains(next[0])) {
                    continue;
                }
                // update the distance
                int dis = next[1] + curr[1];
                pq.offer(new int[] { next[0], dis });
                dist[next[0]] = Math.min(dist[next[0]], dis);
            }
        }
    }

    private void bfsHelper(HashMap<Integer, List<int[]>> graph, int[] dist, HashSet<List<Integer>> finalEdges) {
        int n = dist.length;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        // offer the last node
        q.offer(n - 1);
        while (!q.isEmpty()) {
            int node = q.poll();
            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);
            if (graph.get(node) == null) {
                continue;
            }
            // Now to check which edges to consider
            for (int[] next : graph.get(node)) {
                // else minus the distance and check
                if (dist[next[0]] == (dist[node] - next[1])) {
                    // means can be included in shortest path
                    finalEdges.add(Arrays.asList(next[0], node));
                    finalEdges.add(Arrays.asList(node, next[0]));
                    q.offer(next[0]);
                }
            }
        }
    }

    public static void main(String[] args) {
        FindEdgesInShortestPaths obj = new FindEdgesInShortestPaths();
        int[][] edges = {
                { 0, 1, 4 }, { 0, 2, 1 }, { 1, 3, 2 }, { 1, 4, 3 }, { 1, 5, 1 }, { 2, 3, 1 }, { 3, 5, 3 }, { 4, 5, 2 }
        };
        int n = 6;
        boolean[] ans = obj.findAnswer(n, edges);
        System.out.println(Arrays.toString(ans));
    }
}
