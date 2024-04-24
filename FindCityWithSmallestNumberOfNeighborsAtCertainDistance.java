import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Node {
    int val;
    long cost;

    public Node(int val, long cost) {
        this.val = val;
        this.cost = cost;
    }
}

public class FindCityWithSmallestNumberOfNeighborsAtCertainDistance {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // first of all lets create an adjacency list
        int[] neighbors = new int[n];
        HashMap<Integer, List<Node>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];
            Node forwardEdge = new Node(to, cost);
            Node backwardEdge = new Node(from, cost);
            if (graph.containsKey(from)) {
                List<Node> nebs = graph.get(from);
                nebs.add(forwardEdge);
                graph.put(from, nebs);
            } else {
                List<Node> nebs = new ArrayList<>();
                nebs.add(forwardEdge);
                graph.put(from, nebs);
            }
            if (graph.containsKey(to)) {
                List<Node> nebs = graph.get(to);
                nebs.add(backwardEdge);
                graph.put(to, nebs);
            } else {
                List<Node> nebs = new ArrayList<>();
                nebs.add(backwardEdge);
                graph.put(to, nebs);
            }
        }
        System.out.println(graph);
        int currMinCount = Integer.MAX_VALUE;
        int node = -1;
        // Now we have to perform pathfinding for every node
        for (int i = 0; i < n; i++) {
            if (!graph.containsKey(i)) {
                currMinCount = Integer.MAX_VALUE;
                node = Math.max(node, i);
                continue;
            }
            int count = findNeighborsWithinThreshold(graph, i, distanceThreshold);
            // removing the self count
            count -= 1;
            // Now selecting the required node
            if (currMinCount == count) {
                node = Math.max(node, i);
            } else if (count < currMinCount) {
                currMinCount = count;
                node = i;
            }
            neighbors[i] = count;
        }
        System.out.println(Arrays.toString(neighbors));
        // Now return the required neighbor according to the condition
        return node;
    }

    private int findNeighborsWithinThreshold(HashMap<Integer, List<Node>> graph, int start, long threshold) {
        int neighbors = 0;
        Queue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));// have to be heap over FIFO

        HashSet<Integer> visited = new HashSet<>();
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (visited.contains(curr.val)) {
                continue;
            }
            visited.add(curr.val);
            if (curr.cost > threshold) {
                continue;
            }
            if (curr.cost == threshold) {
                // System.out.println(curr.val + "&&" + curr.cost);
                neighbors += 1;
                continue;
            }
            // System.out.println(curr.val + "&&" + curr.cost);
            neighbors += 1;
            // Add all the other neighbors
            for (Node neighbor : graph.get(curr.val)) {
                if (visited.contains(neighbor.val)) {
                    continue;
                }
                long newCost = curr.cost + neighbor.cost;
                Node newOne = new Node(neighbor.val, newCost);
                pq.offer(newOne);
            }
        }
        return neighbors;
    }

    public static void main(String[] args) {
        FindCityWithSmallestNumberOfNeighborsAtCertainDistance obj = new FindCityWithSmallestNumberOfNeighborsAtCertainDistance();
        int n = 4;
        int distanceThreshold = 4;
        int[][] edges = { { 0, 1, 3 }, { 1, 2, 1 }, { 1, 3, 4 }, { 2, 3, 1 } };
        System.out.println(obj.findTheCity(n, edges, distanceThreshold));
    }
}
