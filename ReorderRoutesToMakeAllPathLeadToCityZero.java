import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ReorderRoutesToMakeAllPathLeadToCityZero {

    public int minReorder(int n, int[][] connections) {
        // Lets create an adjacency list
        HashMap<Integer, List<Integer>> nodes = new HashMap<>();
        HashSet<List<Integer>> forwards = new HashSet<>();
        for (int[] edge : connections) {
            forwards.add(Arrays.asList(edge[0], edge[1]));
            if (nodes.containsKey(edge[0])) {
                List<Integer> neighbors = nodes.get(edge[0]);
                neighbors.add(edge[1]);
                nodes.put(edge[0], neighbors);
            } else {
                List<Integer> neighbors = new ArrayList<>();
                neighbors.add(edge[1]);
                nodes.put(edge[0], neighbors);
            }
            // FOR OPPOSITE,WE TREAT AS AN UNDIRECTED GRAPH
            if (nodes.containsKey(edge[1])) {
                List<Integer> neighbors = nodes.get(edge[1]);
                neighbors.add(edge[0]);
                nodes.put(edge[1], neighbors);
            } else {
                List<Integer> neighbors = new ArrayList<>();
                neighbors.add(edge[0]);
                nodes.put(edge[1], neighbors);
            }
        }
        System.out.println(nodes);
        return dfsHelper(nodes, forwards, new HashSet<>(), 0, 0);
    }

    private int dfsHelper(HashMap<Integer, List<Integer>> nodes, HashSet<List<Integer>> forwards,
            HashSet<Integer> visited, int curr, int count) {
        // Go for all of its neighbors
        if (nodes.get(curr) == null || visited.contains(curr)) {
            return count;
        }
        visited.add(curr);
        List<Integer> neighbors = nodes.get(curr);
        for (int i = 0; i < neighbors.size(); i++) {
            int neighbor = neighbors.get(i);
            if (forwards.contains(Arrays.asList(curr, neighbor)) && !visited.contains(neighbor)) {
                count += 1;
            }
            count = dfsHelper(nodes, forwards, visited, neighbor, count);
        }
        return count;
    }

    public static void main(String[] args) {
        ReorderRoutesToMakeAllPathLeadToCityZero obj = new ReorderRoutesToMakeAllPathLeadToCityZero();
        int[][] connections = { { 0, 1 }, { 1, 3 }, { 2, 3 }, { 4, 0 }, { 4, 5 } };
        int n = 6;
        System.out.println(obj.minReorder(n, connections));
    }
}
