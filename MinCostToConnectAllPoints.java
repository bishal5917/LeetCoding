import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostToConnectAllPoints {

    public int minCostConnectPoints(int[][] points) {
        int cost = 0;
        // USING THE PRIMS ALGORITHM
        HashSet<List<Integer>> visited = new HashSet<>();
        PriorityQueue<List<Integer>> frontiers = new PriorityQueue<>(
                (a, b) -> a.get(2) - b.get(2));
        // add the first cell to the visited and frontier
        int[] first = points[0];
        frontiers.add(Arrays.asList(first[0], first[1], 0));
        // Now keep popping the minimum one and check
        while (!frontiers.isEmpty()) {
            if (visited.size() == points.length) {
                // means all are connected,just break
                break;
            }
            List<Integer> frontier = frontiers.poll();
            int x = frontier.get(0);
            int y = frontier.get(1);
            if (visited.contains(Arrays.asList(x, y))) {
                continue;
            }
            visited.add(Arrays.asList(frontier.get(0), frontier.get(1)));
            cost += frontier.get(2);
            // Now go through all unvisited points and add them to frontiers
            for (int[] point : points) {
                if (visited.contains(Arrays.asList(point[0], point[1]))) {
                    continue;
                }
                // else calculate the manhattan distance and add to frontiers
                int dis = Math.abs(x - point[0]) + Math.abs(y - point[1]);
                frontiers.offer(Arrays.asList(point[0], point[1], dis));
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        MinCostToConnectAllPoints obj = new MinCostToConnectAllPoints();
        int[][] points = { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 } };
        System.out.println(obj.minCostConnectPoints(points));
    }
}