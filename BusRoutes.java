import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BusRoutes {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        // Lets create a graph with routes as nodes
        HashMap<Integer, List<Integer>> g = new HashMap<>();
        initGraph(routes, g);
        System.out.println(g);
        return bfsHelper(g, routes, source, target);
    }

    private void initGraph(int[][] routes, HashMap<Integer, List<Integer>> g) {
        for (int[] route : routes) {
            // we sort the routes
            Arrays.sort(route);
        }
        // Now lets make a graph,we connect if we have common
        for (int i = 0; i < routes.length; i++) {
            for (int j = i + 1; j < routes.length; j++) {
                g.putIfAbsent(i, new ArrayList<>());
                g.putIfAbsent(j, new ArrayList<>());
                if (hasCommon(routes[i], routes[j])) {
                    g.get(i).add(j);
                    g.get(j).add(i);
                }
            }
        }
    }

    private boolean hasCommon(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                return true;
            } else if (a[i] < b[j]) {
                i += 1;
            } else {
                j += 1;
            }
        }
        return false;
    }

    private int bfsHelper(HashMap<Integer, List<Integer>> g, int[][] routes, int s, int e) {
        int len = 1;
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        // we add routes containing starting stop in queue
        for (int i = 0; i < routes.length; i++) {
            int[] route = routes[i];
            if (hasStationOnRoute(route, s)) {
                q.offer(i);
            }
        }
        // Now lets proceed with BFS
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                if (hasStationOnRoute(routes[curr], e)) {
                    // end found return
                    return len;
                }
                if (visited.contains(curr)) {
                    continue;
                }
                visited.add(curr);
                if (!g.containsKey(curr)) {
                    continue;
                }
                for (int next : g.get(curr)) {
                    if (visited.contains(next)) {
                        continue;
                    }
                    q.offer(next);
                }
            }
            len += 1;
        }
        return -1;
    }

    private boolean hasStationOnRoute(int[] route, int pos) {
        for (int r : route) {
            if (r == pos) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BusRoutes obj = new BusRoutes();
        int[][] routes = {
                { 1, 2, 7 }, { 3, 6, 7 }
        };
        int source = 1;
        int target = 6;
        System.out.println(obj.numBusesToDestination(routes, source, target));
    }
}
