import java.util.HashSet;

public class DFSCycleDetection {

    // THIS WORKS FOR DGs Only (Directed Graph)
    public boolean hasCycle(int[][] graph) {
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> visiting = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            if (visited.contains(i)) {
                continue;
            }
            if (checkCycleDfsHelper(graph, visited, visiting, i, false)) {
                return true;
            }
            visited.add(i);
        }
        return false;
    }

    private boolean checkCycleDfsHelper(int[][] graph, HashSet<Integer> visited, HashSet<Integer> visiting, int curr,
            boolean hasCycle) {
        if (graph[curr].length == 0) {
            // means no other outgoing edges
            // we return
            return hasCycle;
        }
        if (visiting.contains(curr)) {
            // means we have come across already occuring node in call stack,
            // means there is a loop
            hasCycle = true;
            return hasCycle;
        }
        visiting.add(curr);
        // Run dfs for all its current adjacencies
        for (int child : graph[curr]) {
            if (!visited.contains(child)) {
                hasCycle = checkCycleDfsHelper(graph, visited, visiting, child, hasCycle);
                visited.add(child);
                visiting.remove(child);
                if (hasCycle == true) {
                    return hasCycle;
                }
            }
        }
        return hasCycle;
    }

    public static void main(String[] args) {
        DFSCycleDetection obj = new DFSCycleDetection();
        int[][] adjacencies = {
                {}, { 0 }, { 1 }, { 1 }, {}, { 2, 4 }, { 4, 3 }, { 5, 6 }
        };
        // int[][] adjacencies = {
        // { 1 }, { 2, 5 }, { 3 }, { 4 }, { 0, 1 }, {}
        // };
        System.out.println(obj.hasCycle(adjacencies));
    }
}