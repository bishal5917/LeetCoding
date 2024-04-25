import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // THIS IS A STRAIGHTFORWARD TOPO SORT PROBLEM
        int[] order = new int[numCourses];
        int[] indegree = new int[numCourses];
        // Lets make a adj list first
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pre : prerequisites) {
            int a = pre[1];
            int b = pre[0];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.get(a).add(b);
            indegree[b] += 1;
        }
        System.out.println(graph);
        // check if cycle is present or not
        if (hasCycle(graph, indegree, numCourses)) {
            return new int[] {};
        }
        List<Integer> ordering = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (visited.contains(i)) {
                continue;
            }
            topoOrderDfsHelper(graph, visited, ordering, i);
            // Now add the node which we started DFS for
            visited.add(i);
            ordering.add(i);
        }
        System.out.println(ordering);
        // Now add to the answer
        for (int i = 0; i < order.length; i++) {
            order[order.length - i - 1] = ordering.get(i);
        }
        return order;
    }

    private boolean hasCycle(HashMap<Integer, List<Integer>> graph, int[] indegree, int numCourses) {
        while (numCourses > 0) {
            // get node with zero indegree
            int node = -1;
            for (int i = 0; i < indegree.length; i++) {
                if (indegree[i] == 0) {
                    node = i;
                }
            }
            if (node == -1) {
                // means if no zero indegree found,return false
                return true;
            }
            // else we cancel that node and all other edges going out
            numCourses -= 1;
            indegree[node] = -1;
            if (graph.get(node) == null) {
                continue;
            }
            // get neighbors
            List<Integer> neighbors = graph.get(node);
            for (int neighbor : neighbors) {
                indegree[neighbor] -= 1;
            }
        }
        return false;
    }

    private void topoOrderDfsHelper(HashMap<Integer, List<Integer>> graph, HashSet<Integer> visited,
            List<Integer> orders,
            int curr) {
        if (graph.get(curr) == null) {
            return;
        }
        // perform dfs on neighbors
        for (int child : graph.get(curr)) {
            if (!visited.contains(child)) {
                topoOrderDfsHelper(graph, visited, orders, child);
                orders.add(child);
                visited.add(child);
            }
        }
    }

    public static void main(String[] args) {
        CourseScheduleII obj = new CourseScheduleII();
        int numCourses = 4;
        int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        int[] ans = obj.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(ans));
    }
}
