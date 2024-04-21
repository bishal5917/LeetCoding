import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        // Lets find the adjacency list first in this case
        HashMap<Integer, List<Integer>> nodes = new HashMap<>();
        // CONVERTING ADJACENCY MATRIX INTO THE ADJACENCY LIST
        for (int i = 0; i < isConnected.length; i++) {
            List<Integer> neighbors = new ArrayList<>();
            int[] row = isConnected[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 1 && i != j) {
                    neighbors.add(j + 1);
                }
            }
            nodes.put(i + 1, neighbors);
        }
        System.out.println(nodes);
        // Now doing dfs to find the number of components
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 1; i <= isConnected.length; i++) {
            // perform bfs
            if (visited.contains(i)) {
                continue;
            }
            provinces += 1;
            // PERFORM DFS NOW
            dfsHelper(nodes, visited, i);
        }
        return provinces;
    }

    private void dfsHelper(HashMap<Integer, List<Integer>> nodes, HashSet<Integer> visited, int curr) {
        if (nodes.get(curr) == null || visited.contains(curr)) {
            return;
        }
        visited.add(curr);
        List<Integer> neighbors = nodes.get(curr);
        // Go for all of its neighbors
        for (int neighbor : neighbors) {
            dfsHelper(nodes, visited, neighbor);
        }
    }

    public static void main(String[] args) {
        NumberOfProvinces obj = new NumberOfProvinces();
        int[][] isConnected = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        System.out.println(obj.findCircleNum(isConnected));
    }
}
