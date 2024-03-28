import java.util.AbstractMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        // At first lets calculate the distance from origin and put it in an array
        int[][] kClosest = new int[k][2];
        // Lets calculate the distance from the origin
        int[] distance = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            distance[i] = point[0] * point[0] + point[1] * point[1];
        }
        // Now put the corresponding index and value in a minheap
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (x, y) -> x.getValue() - y.getValue());
        // Now lets add it
        for (int i = 0; i < points.length; i++) {
            pq.offer(new AbstractMap.SimpleEntry<>(i, distance[i]));
        }
        // Now then pop the k-elements from the min-heap and add
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            kClosest[i] = points[entry.getKey()];
        }
        System.out.println(pq);
        return kClosest;
    }

    public static void main(String[] args) {
        KClosestPointsToOrigin obj = new KClosestPointsToOrigin();
        int[][] points = { { 1, 3 }, { -2, 2 } };
        System.out.println(obj.kClosest(points, 1));
    }
}