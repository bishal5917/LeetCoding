import java.util.AbstractMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxScoreFromRemovingStones {

    public int maximumScore(int a, int b, int c) {
        int count = 0;
        // Select the two MaxOnes and keep removing
        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(
                (x, y) -> y.getValue() - x.getValue()); // Comparator to sort entries by values in descending order
        maxHeap.offer(new AbstractMap.SimpleEntry<>("a", a));
        maxHeap.offer(new AbstractMap.SimpleEntry<>("b", b));
        maxHeap.offer(new AbstractMap.SimpleEntry<>("c", c));
        // Now lets poll
        while (true) {
            // poll the first two and add them back
            Map.Entry<String, Integer> first = maxHeap.poll();
            Map.Entry<String, Integer> second = maxHeap.poll();
            if (first.getValue() >= 1 && second.getValue() >= 1) {
                count += 1;
                maxHeap.offer(new AbstractMap.SimpleEntry<>(first.getKey(), first.getValue() - 1));
                maxHeap.offer(new AbstractMap.SimpleEntry<>(second.getKey(), second.getValue() - 1));
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MaxScoreFromRemovingStones obj = new MaxScoreFromRemovingStones();
        System.out.println(obj.maximumScore(2, 4, 6));
        // 2,4,6
        // 2,3,5
        // 2,2,4
        // 2,1,3
        // 1,1,2
        // 1,0,1
    }
}
