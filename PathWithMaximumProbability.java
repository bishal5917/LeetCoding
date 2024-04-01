import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class PathWithMaximumProbability {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // Now lets create a graph first
        HashMap<Double, List<double[]>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            // for the first to second
            double firstNode = edge[0];
            if (graph.containsKey(firstNode)) {
                List<double[]> next = graph.get(firstNode);
                next.add(new double[] { edge[1], succProb[i] });
                graph.put(firstNode, next);
            } else {
                List<double[]> next = new ArrayList<>();
                next.add(new double[] { edge[1], succProb[i] });
                graph.put(firstNode, next);
            }
            // for the second to first
            double secondNode = edge[1];
            if (graph.containsKey(secondNode)) {
                List<double[]> next = graph.get(secondNode);
                next.add(new double[] { edge[0], succProb[i] });
                graph.put(secondNode, next);
            } else {
                List<double[]> next = new ArrayList<>();
                next.add(new double[] { edge[0], succProb[i] });
                graph.put(secondNode, next);
            }
        }
        System.out.println(graph);
        // USING DIJKSTRAS ALGORITHM WITH A MAX_HEAP
        HashSet<Double> visited = new HashSet<>();
        // will have node and a probability
        // Create a priority queue with custom comparator
        PriorityQueue<double[]> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(b[1], a[1]));
        pq.offer(new double[] { start_node, 1 });
        while (!pq.isEmpty()) {
            double[] polled = pq.poll();
            double node = polled[0];
            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);
            if (node == end_node) {
                return polled[1];
            }
            // now add all its neighbors to the heap,updating the prob
            if (graph.containsKey(node)) {
                List<double[]> neighbs = graph.get(node);
                for (double[] neighb : neighbs) {
                    pq.offer(new double[] { neighb[0], neighb[1] * polled[1] });
                }
            }
        }
        return 0.00000;
    }

    public static void main(String[] args) {
        PathWithMaximumProbability obj = new PathWithMaximumProbability();
        int[][] edges = { { 1, 4 }, { 2, 4 }, { 0, 4 }, { 0, 3 }, { 0, 2 }, { 2, 3 } };
        double[] succProb = { 0.37, 0.17, 0.93, 0.23, 0.39, 0.04 };
        int n = 5;
        int st = 3;
        int end = 4;
        System.out.println(obj.maxProbability(n, edges, succProb, st, end));
    }
}
