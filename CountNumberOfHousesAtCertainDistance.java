import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CountNumberOfHousesAtCertainDistance {

    public int[] countOfPairs(int n, int x, int y) {
        int[] distances = new int[n];
        // Lets create an adjacency list
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i < n; i++) {
            graph.putIfAbsent(i, new ArrayList<>());
            graph.get(i).add(i + 1);
            graph.putIfAbsent(i + 1, new ArrayList<>());
            graph.get(i + 1).add(i);
        }
        // add special edges also
        graph.get(x).add(y);
        graph.get(y).add(x);
        System.out.println(graph);
        // we gotta perform BFS for all nums
        for (int i = 1; i <= n; i++) {
            bfsHelper(graph, distances, i);
        }
        return distances;
    }

    // Lets perform BFS
    private void bfsHelper(HashMap<Integer, List<Integer>> graph, int[] dis, int start) {
        Queue<int[]> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(new int[] { start, 0 });
        visited.add(start);
        // Do this while the queue is not empty
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cost = curr[1];
            if (cost > 0) {
                dis[cost - 1] += 1;
            }
            // Now go for all its neighbors
            for (int next : graph.get(curr[0])) {
                if (!visited.contains(next)) {
                    queue.offer(new int[] { next, cost + 1 });
                    visited.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        CountNumberOfHousesAtCertainDistance obj = new CountNumberOfHousesAtCertainDistance();
        int n = 3;
        int x = 1;
        int y = 3;
        int[] ans = obj.countOfPairs(n, x, y);
        System.out.println(Arrays.toString(ans));
    }
}
