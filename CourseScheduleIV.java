import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseScheduleIV {

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        // Generating an adjacency list
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pre : prerequisites) {
            int a = pre[0];
            int b = pre[1];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.get(a).add(b);
        }
        HashMap<Integer, Set<Integer>> cache = new HashMap<>();
        // we run DFS for all courses,and implement caching along the way
        for (int i = 0; i < numCourses; i++) {
            dfsHelper(graph, cache, i);
        }
        System.out.println(cache);
        // Now time to check the prerequisite
        for (int[] query : queries) {
            int a = query[0];
            int b = query[1];
            if (!cache.containsKey(a)) {
                ans.add(false);
                continue;
            }
            if (cache.get(a).contains(b)) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }

    // LETS DO THIS USING CACHED DFS
    private Set<Integer> dfsHelper(HashMap<Integer, List<Integer>> graph, HashMap<Integer, Set<Integer>> cache,
            int node) {
        if (cache.containsKey(node)) {
            return cache.get(node);
        }
        if (!graph.containsKey(node)) {
            return new HashSet<>();
        }
        // Now go for all its direct neighbors
        for (int child : graph.get(node)) {
            Set<Integer> nodes = dfsHelper(graph, cache, child);
            cache.putIfAbsent(node, new HashSet<>());
            cache.get(node).add(child);
            cache.get(node).addAll(nodes);
        }
        return cache.get(node);
    }

    public static void main(String[] args) {
        CourseScheduleIV obj = new CourseScheduleIV();
        int numCourses = 3;
        int[][] prerequisites = { { 1, 2 }, { 1, 0 }, { 2, 0 } };
        int[][] queries = { { 1, 0 }, { 1, 2 } };
        System.out.println(obj.checkIfPrerequisite(numCourses, prerequisites, queries));
    }
}
