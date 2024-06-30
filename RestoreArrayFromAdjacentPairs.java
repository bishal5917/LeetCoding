import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class RestoreArrayFromAdjacentPairs {

    public int[] restoreArray(int[][] adjacentPairs) {
        // Lets create a graph first
        int start = -1;
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            int a = pair[0];
            int b = pair[1];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        // FINDING THE STARTING POINT
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            if (entry.getValue().size() == 1) {
                start = entry.getKey();
                break;
            }
        }
        // Lets declare an answer array
        int[] ans = new int[graph.size()];
        System.out.println(graph);
        List<Integer> order = dfsHelper(graph, new HashSet<>(),
                new ArrayList<>(), start);
        for (int i = 0; i < order.size(); i++) {
            ans[i] = order.get(i);
        }
        return ans;
    }

    private List<Integer> dfsHelper(HashMap<Integer, List<Integer>> g, HashSet<Integer> visited, List<Integer> order,
            int node) {
        order.add(node);
        visited.add(node);
        if (g.get(node) != null) {
            for (int next : g.get(node)) {
                if (visited.contains(next)) {
                    continue;
                }
                order = dfsHelper(g, visited, order, next);
            }
        }
        return order;
    }

    public static void main(String[] args) {
        RestoreArrayFromAdjacentPairs obj = new RestoreArrayFromAdjacentPairs();
        int[][] adjacentPairs = { { 4, -10 }, { -1, 3 }, { 4, -3 }, { -3, 3 } };
        int[] ans = obj.restoreArray(adjacentPairs);
        System.out.println(Arrays.toString(ans));
    }
}
