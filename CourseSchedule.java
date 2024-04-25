import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Lets make a directed graph first
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pre : prerequisites) {
            int from = pre[0];
            int to = pre[1];
            if (graph.containsKey(from)) {
                List<Integer> nebs = graph.get(from);
                nebs.add(to);
                graph.put(from, nebs);
            } else {
                List<Integer> nebs = new ArrayList<>();
                nebs.add(to);
                graph.put(from, nebs);
            }
            // and also calculating indegree
            indegree[to] += 1;
        }
        System.out.println(graph);
        System.out.println(Arrays.toString(indegree));
        // Lets perform cycle detection using top sort
        // do this till all our nodes are cancelled
        // we will break if we can't find zero indegree node
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
                return false;
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
        return true;
    }

    public static void main(String[] args) {
        CourseSchedule obj = new CourseSchedule();
        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 }, { 0, 1 } };
        System.out.println(obj.canFinish(numCourses, prerequisites));
    }
}
