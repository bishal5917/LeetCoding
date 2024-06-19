import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FrogPositionAfterTSeconds {

    public double frogPosition(int n, int[][] edges, int t, int target) {
        // Lets create a graph first
        HashMap<Integer, List<Integer>> g = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            g.putIfAbsent(a, new ArrayList<>());
            g.putIfAbsent(b, new ArrayList<>());
            g.get(a).add(b);
            g.get(b).add(a);
        }
        return bfsHelper(g, n, t, target);
    }

    private double bfsHelper(HashMap<Integer, List<Integer>> g, int n, int t, int target) {
        boolean[] visited = new boolean[n + 1];
        double[] prob = new double[n + 1];
        prob[1] = 1.0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        while (!q.isEmpty() && t > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                if (visited[curr]) {
                    continue;
                }
                visited[curr] = true;
                if (g.get(curr) == null) {
                    continue;
                }
                int possibleNext = 0;
                for (int next : g.get(curr)) {
                    if (!visited[next]) {
                        possibleNext += 1;
                    }
                }
                for (int next : g.get(curr)) {
                    if (!visited[next]) {
                        q.offer(next);
                        // update the probability
                        double currProb = (double) prob[curr];
                        double nextProb = (double) 1 / possibleNext;
                        prob[next] = currProb * nextProb;
                    }
                }
                if (possibleNext > 0) {
                    // means cant return back,so zero
                    prob[curr] = 0.0;
                }
            }
        }
        System.out.println(Arrays.toString(prob));
        return prob[target];
    }

    public static void main(String[] args) {
        FrogPositionAfterTSeconds obj = new FrogPositionAfterTSeconds();
        int[][] edges = {
                { 1, 2 }, { 1, 3 }, { 1, 7 }, { 2, 4 }, { 2, 6 }, { 3, 5 }
        };
        int t = 2;
        int n = 7;
        int target = 4;
        System.out.println(obj.frogPosition(n, edges, t, target));
    }
}
