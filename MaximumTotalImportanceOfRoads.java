import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;

public class MaximumTotalImportanceOfRoads {

    public long maximumImportance(int n, int[][] roads) {
        // Now the thing is we have to find the indegree
        // the one with the max indegree will get the maxImportance
        long total = 0;
        int[] indegree = new int[n];
        for (int[] road : roads) {
            indegree[road[0]] = indegree[road[0]] + 1;
            indegree[road[1]] = indegree[road[1]] + 1;
        }
        // add the index with indegree to the maxHeap
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (int i = 0; i < indegree.length; i++) {
            pq.offer(new AbstractMap.SimpleEntry<>(i, indegree[i]));
        }
        int imp = n;
        // Now we gotta assign importance based on indegrees
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            indegree[entry.getKey()] = imp--;
        }
        // Now indegree array became importance array
        System.out.println(Arrays.toString(indegree));
        // Now add the importance
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            total = total + indegree[a] + indegree[b];
        }
        return total;
    }

    public static void main(String[] args) {
        MaximumTotalImportanceOfRoads obj = new MaximumTotalImportanceOfRoads();
        int n = 5;
        int[][] roads = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 0, 2 }, { 1, 3 }, { 2, 4 } };
        System.out.println(obj.maximumImportance(n, roads));
    }
}
