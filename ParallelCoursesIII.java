import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ParallelCoursesIII {

    public int minimumTime(int n, int[][] relations, int[] time) {
        int ans = 0;
        // Lets create a graph first
        int[] indegree = new int[n + 1];
        int[] maxTime = new int[n + 1];
        HashMap<Integer, List<Integer>> g = new HashMap<>();
        for (int[] relation : relations) {
            int a = relation[0];
            int b = relation[1];
            g.putIfAbsent(a, new ArrayList<>());
            g.get(a).add(b);
            indegree[b] += 1;
        }
        System.out.println(Arrays.toString(indegree));
        Queue<Integer> q = new LinkedList<>();
        // Add all zeroes indegree to queue
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                maxTime[i] = time[i - 1];
            }
        }
        System.out.println(q);
        bfsTopoHelper(g, indegree, q, time, maxTime);
        System.out.println(Arrays.toString(maxTime));
        // Now lets track the maxTime
        for (int t : maxTime) {
            ans = Math.max(ans, t);
        }
        return ans;
    }

    private void bfsTopoHelper(HashMap<Integer, List<Integer>> g, int[] indegree, Queue<Integer> q, int[] time,
            int[] maxTime) {
        // Now we do toposort using BFS while tracking time
        while (!q.isEmpty()) {

            int node = q.poll();
            // track the time
            if (!g.containsKey(node)) {
                continue;
            }
            for (int next : g.get(node)) {
                // Note that time is 1 indexed array
                maxTime[next] = Math.max(maxTime[next], maxTime[node] + time[next - 1]);
                indegree[next] -= 1;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        ParallelCoursesIII obj = new ParallelCoursesIII();
        int n = 3;
        int[][] relations = { { 1, 3 }, { 2, 3 } };
        int[] time = { 3, 2, 5 };
        System.out.println(obj.minimumTime(n, relations, time));
    }
}
