import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumStarSumOfGraph {

    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int sum = Integer.MIN_VALUE;
        // lets just make an adjacency list first
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        // only add the neighbors with the negative edges
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.putIfAbsent(a, new ArrayList<>());
            if (vals[b] >= 0) {
                graph.get(a).add(vals[b]);
            }
            graph.putIfAbsent(b, new ArrayList<>());
            if (vals[a] >= 0) {
                graph.get(b).add(vals[a]);
            }
        }
        // Now add the nodes if they aren't added yet
        for (int i = 0; i < vals.length; i++) {
            graph.putIfAbsent(i, new ArrayList<>());
        }
        System.out.println(graph);
        // Now check for the max star sum
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            int currSum = 0;
            int centerNode = entry.getKey();
            List<Integer> nebs = entry.getValue();
            Collections.sort(nebs, Collections.reverseOrder());
            for (int i = 0; i < Math.min(k, nebs.size()); i++) {
                currSum += nebs.get(i);
            }
            currSum += vals[centerNode];
            sum = Math.max(currSum, sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        MaximumStarSumOfGraph obj = new MaximumStarSumOfGraph();
        int[] vals = { 1, 2, 3, 4, 10, -10, -20 };
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 1, 3 }, { 3, 4 }, { 3, 5 }, { 3, 6 } };
        System.out.println(obj.maxStarSum(vals, edges, 2));
    }
}
