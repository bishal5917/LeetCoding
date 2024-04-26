import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LoudAndRich {

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int[] ans = new int[quiet.length];
        // Create a graph using adjacency list
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < richer.length; i++) {
            int[] edge = richer[i];
            int a = edge[1];
            int b = edge[0];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.get(a).add(b);
        }
        Arrays.fill(ans, -1);
        // Running DFS for each and every nodes in the graph
        for (int i = 0; i < quiet.length; i++) {
            dfsHelper(graph, quiet, ans, i);
        }
        return ans;
    }

    // DFS with caching
    private int dfsHelper(HashMap<Integer, List<Integer>> graph, int[] quiet, int[] ans, int node) {
        if (ans[node] == -1) {
            ans[node] = node;
            if (graph.containsKey(node)) {
                for (int child : graph.get(node)) {
                    int ch = dfsHelper(graph, quiet, ans, child);
                    if (quiet[ch] < quiet[ans[node]])
                        ans[node] = ch;
                }
            }
        }
        return ans[node];
    }

    public static void main(String[] args) {
        LoudAndRich obj = new LoudAndRich();
        int[][] richer = { { 1, 0 }, { 2, 1 }, { 3, 1 }, { 3, 7 }, { 4, 3 }, { 5, 3 }, { 6, 3 } };
        int[] quiet = { 3, 2, 5, 4, 6, 1, 7, 0 };
        int[] ans = obj.loudAndRich(richer, quiet);
        System.out.println(Arrays.toString(ans));
    }
}
