import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumNumberOfVerticesToReachAllNodes {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> nodes = new ArrayList<>();
        HashMap<Integer, Integer> graph = new HashMap<>();
        for (List<Integer> edge : edges) {
            int from = edge.get(0);
            int to = edge.get(1);
            if (!graph.containsKey(from)) {
                graph.put(from, 0);
            }
            if (graph.containsKey(to)) {
                graph.put(to, graph.get(to) + 1);
            } else {
                graph.put(to, 1);
            }
        }
        // Now add the nodes with zero in-degrees
        for (Map.Entry<Integer, Integer> entry : graph.entrySet()) {
            if (entry.getValue() == 0) {
                nodes.add(entry.getKey());
            }
        }
        return nodes;
    }

    public static void main(String[] args) {
        MinimumNumberOfVerticesToReachAllNodes obj = new MinimumNumberOfVerticesToReachAllNodes();
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(0, 2));
        edges.add(Arrays.asList(2, 5));
        edges.add(Arrays.asList(3, 4));
        edges.add(Arrays.asList(4, 2));
        System.out.println(obj.findSmallestSetOfVertices(6, edges));
    }
}
