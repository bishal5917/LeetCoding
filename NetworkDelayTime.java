import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        int runningTime = 0;
        // Lets first create a adjacency list with next neighbor and time to reach that
        // neighbor
        HashMap<Integer, List<int[]>> adjacency = new HashMap<>();
        for (int[] time : times) {
            int node = time[0];
            if (adjacency.containsKey(node)) {
                List<int[]> next = adjacency.get(node);
                next.add(new int[] { time[1], time[2] });
                adjacency.put(node, next);
            } else {
                List<int[]> next = new ArrayList<>();
                next.add(new int[] { time[1], time[2] });
                adjacency.put(node, next);
            }
        }
        // System.out.println(adjacency);
        // NOW ITS TiME TO APPLY DIJKSTRA'S ALGORITHM
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        HashSet<Integer> visited = new HashSet<>();
        pq.offer(new int[] { k, 0 });
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNode = curr[0];
            if (visited.contains(currNode)) {
                continue;
            }
            runningTime = curr[1];
            visited.add(currNode);
            // add all its neighbors
            if (adjacency.containsKey(currNode)) {
                List<int[]> neighbs = adjacency.get(currNode);
                // add all the neighbs to the heap updating the time
                for (int[] neighb : neighbs) {
                    pq.offer(new int[] { neighb[0], neighb[1] + curr[1] });
                }
            }
        }
        return visited.size() == n ? runningTime : -1;
    }

    public static void main(String[] args) {
        NetworkDelayTime obj = new NetworkDelayTime();
        int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
        int n = 4;
        int k = 2;
        System.out.println(obj.networkDelayTime(times, n, k));
    }
}