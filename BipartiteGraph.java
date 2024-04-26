import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {

    public boolean isBipartite(int[][] graph) {
        // we do this using Coloring through BFS
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
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

    private boolean isBipartiteBfsHelper(int[][] graph, int[] visited, int curr) {
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
            for (int neighbor : graph[node]) {
                if (visited[neighbor] == 0) {
                    // just add to the queue
                    queue.offer(neighbor);
                } else if (visited[neighbor] == 1) {
                    canColorRed = false;
                } else if (visited[neighbor] == 2) {
                    canColorBlue = false;
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
        BipartiteGraph obj = new BipartiteGraph();
        int[][] graph = { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } };
        System.out.println(obj.isBipartite(graph));
    }
}
