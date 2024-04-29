import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ColorNode {
    int val;
    int color;

    // Color = 0 for RED and 1 for BLUE
    public ColorNode(int val, int color) {
        this.val = val;
        this.color = color;
    }
}

public class ShortestPathWithAlternatingColors {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] paths = new int[n];
        // Initialize path by Integer.MAX_VALUE
        for (int i = 0; i < paths.length; i++) {
            paths[i] = Integer.MAX_VALUE;
        }
        paths[0] = 0;
        // Lets create an adjacency list first
        HashMap<Integer, List<ColorNode>> graph = new HashMap<>();
        // FOR RED EDGES
        for (int[] edge : redEdges) {
            int from = edge[0];
            int to = edge[1];
            ColorNode next = new ColorNode(to, 0);
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(next);
        }
        // FOR BLUE EDGES
        for (int[] edge : blueEdges) {
            int from = edge[0];
            int to = edge[1];
            ColorNode next = new ColorNode(to, 1);
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(next);
        }
        System.out.println(graph);
        // Now we gotta do a BFS for nodes 1 to n-1
        for (int i = 1; i < n; i++) {
            alternatePathBfsHelper(graph, i, 0, paths);
            alternatePathBfsHelper(graph, i, 1, paths);
        }
        // Now if there is any infinity,change to -1
        for (int i = 0; i < paths.length; i++) {
            if (paths[i] == Integer.MAX_VALUE) {
                paths[i] = -1;
            }
        }
        return paths;
    }

    private void alternatePathBfsHelper(HashMap<Integer, List<ColorNode>> graph, int goal, int initColor, int[] paths) {
        int length = 0;
        Queue<ColorNode> queue = new LinkedList<>();
        HashSet<List<Integer>> visited = new HashSet<>();
        queue.offer(new ColorNode(0, initColor));
        // Remaining to consider another color also
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                ColorNode curr = queue.poll();
                if (curr.val == goal) {
                    paths[goal] = Math.min(paths[goal], length);
                    return;
                }
                if (visited.contains(Arrays.asList(curr.val, curr.color))) {
                    continue;
                }
                visited.add(Arrays.asList(curr.val, curr.color));
                // check visited
                if (graph.get(curr.val) == null) {
                    continue;
                }
                List<ColorNode> neighbors = graph.get(curr.val);
                for (ColorNode node : neighbors) {
                    // We want another color,alternate
                    if (curr.color != node.color) {
                        queue.offer(node);
                    }
                }
            }
            length += 1;
        }
    }

    public static void main(String[] args) {
        ShortestPathWithAlternatingColors obj = new ShortestPathWithAlternatingColors();
        int n = 3;
        int[][] redEdges = { { 0, 1 }, { 0, 2 } };
        int[][] blueEdges = { { 1, 0 } };
        int[] ans = obj.shortestAlternatingPaths(n, redEdges, blueEdges);
        System.out.println(Arrays.toString(ans));
    }
}
