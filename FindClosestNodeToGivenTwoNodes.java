import java.util.HashMap;
import java.util.HashSet;

public class FindClosestNodeToGivenTwoNodes {

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int minDis = Integer.MAX_VALUE;
        int node = -1;
        HashMap<Integer, Integer> distanceFrom1 = new HashMap<>();
        HashMap<Integer, Integer> distanceFrom2 = new HashMap<>();
        dfsHelper(edges, distanceFrom1, new HashSet<>(), node1, 0);
        dfsHelper(edges, distanceFrom2, new HashSet<>(), node2, 0);
        System.out.println(distanceFrom1);
        System.out.println(distanceFrom2);
        // Now to calculating the minimum of the Max Distances
        for (int i = 0; i < edges.length; i++) {
            if (distanceFrom1.containsKey(i) && distanceFrom2.containsKey(i)) {
                int dis = Math.max(distanceFrom1.get(i), distanceFrom2.get(i));
                if (dis < minDis) {
                    minDis = dis;
                    node = i;
                }
            }
        }
        return node;
    }

    private int dfsHelper(int[] edges, HashMap<Integer, Integer> dis, HashSet<Integer> visiting, int node,
            int distance) {
        if (visiting.contains(node) || node == -1) {
            // means a cycle,or end of the tree
            // just terminate
            return node;
        }
        visiting.add(node);
        dis.put(node, distance);
        distance = dfsHelper(edges, dis, visiting, edges[node], distance + 1);
        return distance;
    }

    public static void main(String[] args) {
        FindClosestNodeToGivenTwoNodes obj = new FindClosestNodeToGivenTwoNodes();
        int[] edges = { 1, 2, -1 };
        int node1 = 0;
        int node2 = 2;
        System.out.println(obj.closestMeetingNode(edges, node1, node2));
    }
}
