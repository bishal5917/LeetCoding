import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FlowerPlantingWithNoAdjacent {

    public int[] gardenNoAdj(int n, int[][] paths) {
        // flower gonna be our visited array
        int[] flowers = new int[n + 1];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : paths) {
            int a = edge[0];
            int b = edge[1];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.get(a).add(b);
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(b).add(a);
        }
        System.out.println(graph);
        // lets create a graph of adjacency list first
        for (int i = 1; i <= n; i++) {
            if (flowers[i] == 0) {
                isBipartiteBfsHelper(graph, flowers, i);
            }
        }
        // now remove the first one before returning
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = flowers[i + 1];
        }
        return ans;
    }

    private boolean isBipartiteBfsHelper(HashMap<Integer, List<Integer>> graph, int[] visited, int curr) {
        // we have four choices 1,2,3,4
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(curr);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (visited[node] == 1 || visited[node] == 2 || visited[node] == 3 || visited[node] == 4) {
                continue;
            }
            // now take all its neighbors
            HashSet<Integer> planted = new HashSet<>();
            if (graph.get(node) != null) {
                for (int neighbor : graph.get(node)) {
                    if (visited[neighbor] == 0) {
                        // just add to the queue
                        queue.offer(neighbor);
                    } else {
                        planted.add(visited[neighbor]);
                    }
                }
            }
            // Now add color to the current node
            for (int i = 1; i <= 4; i++) {
                if (planted.contains(i)) {
                    continue;
                }
                visited[node] = i;
                break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FlowerPlantingWithNoAdjacent obj = new FlowerPlantingWithNoAdjacent();
        int n = 3;
        int[][] paths = { { 1, 2 }, { 2, 3 }, { 3, 1 } };
        int[] ans = obj.gardenNoAdj(n, paths);
        System.out.println(Arrays.toString(ans));
    }
}