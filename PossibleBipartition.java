import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PossibleBipartition {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        // we do this using Coloring through BFS
        int[] visited = new int[n + 1];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : dislikes) {
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
            if (visited[i] == 0) {
                boolean ans = isBipartiteBfsHelper(graph, visited, i);
                if (ans == false) {
                    return false;
                }
            }
        }
        System.out.println(Arrays.toString(visited));
        return true;
    }

    private boolean isBipartiteBfsHelper(HashMap<Integer, List<Integer>> graph, int[] visited, int curr) {
        // let 1 and 2 be two different colors,1=RED,2=BLUE
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(curr);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (visited[node] == 1 || visited[node] == 2) {
                continue;
            }
            // now take all its neighbors
            boolean canColorRed = true;
            boolean canColorBlue = true;
            if (graph.get(node) != null) {
                for (int neighbor : graph.get(node)) {
                    if (visited[neighbor] == 0) {
                        // just add to the queue
                        queue.offer(neighbor);
                    } else if (visited[neighbor] == 1) {
                        canColorRed = false;
                    } else if (visited[neighbor] == 2) {
                        canColorBlue = false;
                    }
                }
            }
            // Now add color to the current node
            if (canColorRed == false && canColorBlue == false) {
                return false;
            } else if (canColorRed == true) {
                visited[node] = 1;
            } else if (canColorBlue == true) {
                visited[node] = 2;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PossibleBipartition obj = new PossibleBipartition();
        int n = 4;
        int[][] dislikes = { { 1, 2 }, { 1, 3 }, { 2, 4 } };
        System.out.println(obj.possibleBipartition(n, dislikes));
    }
}
