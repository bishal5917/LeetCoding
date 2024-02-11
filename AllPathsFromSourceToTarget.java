import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPathsFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return allPathsRecursiveHelper(graph, new ArrayList<>(), 0, new ArrayList<>(Arrays.asList(0)));
    }

    private List<List<Integer>> allPathsRecursiveHelper(int[][] graph, List<List<Integer>> paths, int currNode,
            List<Integer> currPath) {
        if (currNode == graph.length - 1) {
            // means the target has reached
            // add the currentpath to the paths array
            paths.add(new ArrayList<>(currPath));
            return paths;
        }
        for (int node : graph[currNode]) {
            currPath.add(node);
            allPathsRecursiveHelper(graph, paths, node, currPath);
            currPath.remove(currPath.size() - 1);
        }
        return paths;
    }

    public static void main(String[] args) {
        AllPathsFromSourceToTarget obj = new AllPathsFromSourceToTarget();
        // int[][] graph = { { 1, 2 }, { 3 }, { 3 }, {} };
        int[][] graph = { { 4, 3, 1 }, { 3, 2, 4 }, { 3 }, { 4 }, {} };
        List<List<Integer>> paths = obj.allPathsSourceTarget(graph);
        System.out.println(paths);
    }

}
