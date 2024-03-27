import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReduceArraySizeToTheHalf {

    public int minSetSize(int[] arr) {
        int n = arr.length;
        int count = 0;
        // Lets count first
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // Now lets push all elements in a MAX-HEAP
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()); // Comparator to sort entries by values in descending order
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.offer(entry);
        }
        // Now pop and check if we can reduce the size to half
        while (!maxHeap.isEmpty()) {
            if (n <= arr.length / 2) {
                break;
            }
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            n = n - entry.getValue();
            count += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        ReduceArraySizeToTheHalf obj = new ReduceArraySizeToTheHalf();
        int[] arr = { 3, 3, 3, 3, 5, 5, 5, 2, 2, 7 };
        System.out.println(obj.minSetSize(arr));
    }
}
