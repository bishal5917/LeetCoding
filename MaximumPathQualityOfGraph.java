import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MaximumPathQualityOfGraph {

    int quality = 0;

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        // Time to create a graph first
        HashMap<Integer, List<int[]>> g = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            g.putIfAbsent(a, new ArrayList<>());
            g.putIfAbsent(b, new ArrayList<>());
            g.get(a).add(new int[] { b, edge[2] });
            g.get(b).add(new int[] { a, edge[2] });
        }
        if (values.length != 0) {
            quality = values[0];
        }
        dfsHelper(g, values, 0, 0, maxTime, new ArrayList<>());
        return quality;
    }

    // Now time to do a dfs
    private int dfsHelper(HashMap<Integer, List<int[]>> g, int[] values, int curr, int time, int maxTime,
            List<Integer> path) {
        if (time > maxTime) {
            return time;
        }
        if (g.get(curr) == null) {
            return time;
        }
        // Now lets go for nebs
        for (int[] next : g.get(curr)) {
            time += next[1];
            path.add(next[0]);
            time = dfsHelper(g, values, next[0], time, maxTime, path);
            time -= next[1];
            path.remove(path.size() - 1);
            if (!path.isEmpty() && path.get(path.size() - 1) == 0) {
                trackQuality(path, values);
            }
        }
        return time;
    }

    private void trackQuality(List<Integer> path, int[] values) {
        int currQuality = 0;
        boolean[] used = new boolean[values.length];
        for (int node : path) {
            if (used[node]) {
                continue;
            }
            currQuality += values[node];
            used[node] = true;
        }
        quality = Math.max(quality, currQuality);
    }

    public static void main(String[] args) {
        MaximumPathQualityOfGraph obj = new MaximumPathQualityOfGraph();
        int[] values = { 0, 32, 10, 43 };
        int[][] edges = { { 0, 1, 10 }, { 1, 2, 15 }, { 0, 3, 10 } };
        int maxTime = 49;
        System.out.println(obj.maximalPathQuality(values, edges, maxTime));
    }
}
