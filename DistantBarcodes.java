import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class DistantBarcodes {

    public int[] rearrangeBarcodes(int[] barcodes) {
        List<Integer> codes = new ArrayList<>();
        // first lets count the characters
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int code : barcodes) {
            if (map.containsKey(code)) {
                map.put(code, map.get(code) + 1);
            } else {
                map.put(code, 1);
            }
        }
        // Initialize priority-queue for max nums and a queue for tracking prev
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());
        Queue<Map.Entry<Integer, Integer>> queue = new LinkedList<>();
        // add the entries to the pq
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        // Now lets place the chars
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> polled = pq.poll();
            // add the previously polled to the queue
            if (!queue.isEmpty()) {
                pq.offer(queue.poll());
            }
            int key = polled.getKey();
            int val = polled.getValue();
            codes.add(key);
            // And update to queue
            if (val - 1 > 0) {
                queue.offer(new AbstractMap.SimpleEntry<>(key, val - 1));
            }
        }
        System.out.println(codes);
        // copy back to original array
        for (int i = 0; i < codes.size(); i++) {
            barcodes[i] = codes.get(i);
        }
        return barcodes;
    }

    public static void main(String[] args) {
        DistantBarcodes obj = new DistantBarcodes();
        int[] barcodes = { 1, 1, 1, 1, 2, 2, 3, 3 };
        int[] ans = obj.rearrangeBarcodes(barcodes);
        System.out.println(Arrays.toString(ans));
    }
}