import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair {
    int node;
    int distance;

    public Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

public class MinimumScoreOfPathBetweenTwoCities {

    public int minScore(int n, int[][] roads) {
        // first gotta create an adjacency list
        HashMap<Integer, List<Pair>> graph = new HashMap<>();
        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];
            int cost = road[2];
            Pair forward = new Pair(to, cost);
            Pair backward = new Pair(from, cost);
            if (graph.containsKey(from)) {
                List<Pair> nebs = graph.get(from);
                nebs.add(forward);
                graph.put(from, nebs);
            } else {
                List<Pair> nebs = new ArrayList<>();
                nebs.add(forward);
                graph.put(from, nebs);
            }
            if (graph.containsKey(to)) {
                List<Pair> nebs = graph.get(to);
                nebs.add(backward);
                graph.put(to, nebs);
            } else {
                List<Pair> nebs = new ArrayList<>();
                nebs.add(backward);
                graph.put(to, nebs);
            }
        }
        System.out.println(graph);
        // USING THE BFS APPROACH
        int score = Integer.MAX_VALUE;
        HashSet<Integer> visited = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(1, Integer.MAX_VALUE));
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            if (visited.contains(curr.node)) {
                continue;
            }
            visited.add(curr.node);
            // now add all the neighbors to the queue
            List<Pair> neighbors = graph.get(curr.node);
            for (Pair neighbor : neighbors) {
                score = Math.min(score, neighbor.distance);
                queue.offer(neighbor);
            }
        }
        return score;
    }

    public static void main(String[] args) {
        MinimumScoreOfPathBetweenTwoCities obj = new MinimumScoreOfPathBetweenTwoCities();
        int n = 4;
        int[][] roads = { { 1, 2, 9 }, { 2, 3, 6 }, { 2, 4, 5 }, { 1, 4, 7 } };
        System.out.println(obj.minScore(n, roads));
    }
}
