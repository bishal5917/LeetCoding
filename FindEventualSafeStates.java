import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindEventualSafeStates {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] outdegree = new int[graph.length];
        List<Integer> safe = new ArrayList<>();
        HashMap<Integer, List<Integer>> incomings = new HashMap<>();
        // get the nodes having zero outdegree and add to queue if any
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            outdegree[i] = graph[i].length;
            if (graph[i].length == 0) {
                queue.offer(i);
            }
            // Now find all the incoming nodes for a node
            for (int node : graph[i]) {
                incomings.putIfAbsent(node, new ArrayList<>());
                incomings.get(node).add(i);
            }
        }
        System.out.println(incomings);
        // Now keep removing nodes and edges going to it
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            // mark as safe,since its the zero outdegree one
            safe.add(curr);
            // Now decrease the outdegrees of the node that are incoming to it by 1
            // and if we get 0 , add to queue
            if (incomings.get(curr) == null) {
                continue;
            }
            for (int inNode : incomings.get(curr)) {
                int currOutDegree = outdegree[inNode];
                outdegree[inNode] = currOutDegree - 1;
                if (outdegree[inNode] == 0) {
                    queue.offer(inNode);
                }
            }
        }
        Collections.sort(safe);
        return safe;
    }

    public static void main(String[] args) {
        FindEventualSafeStates obj = new FindEventualSafeStates();
        int[][] graph = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
        System.out.println(obj.eventualSafeNodes(graph));
    }
}
