import java.util.HashMap;
import java.util.Map;

public class FindCenterOfStarGraph {

    public int findCenter(int[][] edges) {
        HashMap<Integer, Integer> degrees = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            if (degrees.containsKey(a)) {
                degrees.put(a, degrees.get(a) + 1);
            } else {
                degrees.put(a, 1);
            }
            if (degrees.containsKey(b)) {
                degrees.put(b, degrees.get(b) + 1);
            } else {
                degrees.put(b, 1);
            }
        }
        // Find the one with the degree equal to nodes-1
        for (Map.Entry<Integer, Integer> entry : degrees.entrySet()) {
            if (entry.getValue() == degrees.size() - 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindCenterOfStarGraph obj = new FindCenterOfStarGraph();
        int[][] edges = { { 1, 2 }, { 2, 3 }, { 4, 2 } };
        System.out.println(obj.findCenter(edges));
    }
}
