import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Vertex {
    int id;
    boolean isApple;
    int time;

    public Vertex(int id, boolean isApple, int time) {
        this.id = id;
        this.isApple = isApple;
        this.time = time;
    }
}

public class MinimumTimeToCollectAllApplesInTree {

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // Lets first create an adjacency list
        HashMap<Integer, List<Vertex>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.get(a).add(new Vertex(b, hasApple.get(b), 0));
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(b).add(new Vertex(a, hasApple.get(a), 0));
        }
        HashMap<Integer, List<Vertex>> adjs = new HashMap<>();
        Vertex root = new Vertex(0, hasApple.get(0), 0);
        createOneWayAdjList(graph, adjs, root);
        System.out.println(adjs);
        // perform the DFS from the root node
        dfsHelper(adjs, root);
        return root.time;
    }

    private void createOneWayAdjList(HashMap<Integer, List<Vertex>> graph, HashMap<Integer, List<Vertex>> adjs,
            Vertex root) {
        Queue<Vertex> queue = new LinkedList<>();
        HashSet<Integer> processed = new HashSet<>();
        queue.offer(root);
        processed.add(root.id);
        // Lets create top-down (one on one adjacency list)
        // starting from 0 node
        while (!queue.isEmpty()) {
            Vertex curr = queue.poll();
            if (graph.get(curr.id) == null) {
                continue;
            }
            List<Vertex> ch = graph.get(curr.id);
            List<Vertex> newCh = new ArrayList<>();
            for (Vertex v : ch) {
                if (processed.contains(v.id)) {
                    continue;
                }
                processed.add(v.id);
                queue.offer(v);
                newCh.add(v);
            }
            adjs.put(curr.id, newCh);
        }
    }

    private void dfsHelper(HashMap<Integer, List<Vertex>> graph, Vertex curr) {
        // Now go for its childs
        if (graph.get(curr.id) != null) {
            for (Vertex child : graph.get(curr.id)) {
                dfsHelper(graph, child);
                // System.out.println(curr.id + "-->" + child.id);
                // Now lets keep updating the time
                if (child.isApple) {
                    // update the time for parent
                    curr.time += child.time + 2;
                } else {
                    // if its not an apple,only update the tine for parent
                    // if it's not zero previously
                    if (child.time != 0) {
                        curr.time += child.time + 2;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        MinimumTimeToCollectAllApplesInTree obj = new MinimumTimeToCollectAllApplesInTree();
        int n = 7;
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 6 } };
        List<Boolean> hasApple = new ArrayList<>(
                Arrays.asList(false, false, true, false, true, true, false));
        System.out.println(obj.minTime(n, edges, hasApple));
    }
}
