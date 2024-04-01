import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReorganizeString {

    public String reorganizeString(String s) {
        StringBuilder str = new StringBuilder();
        // first lets count the characters
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        // Initialize priority-queue for max nums and a queue for tracking prev
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        // add the entries to the pq
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        // Now lets place the chars
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> polled = pq.poll();
            // add the previously polled to the queue
            if (!queue.isEmpty()) {
                pq.offer(queue.poll());
            }
            char key = polled.getKey();
            int val = polled.getValue();
            str.append(key);
            // And update to queue
            if (val - 1 > 0) {
                queue.offer(new AbstractMap.SimpleEntry<>(key, val - 1));
            }
        }
        // Lets place the alternate characters
        return str.length() == s.length() ? str.toString() : "";
    }

    public static void main(String[] args) {
        ReorganizeString obj = new ReorganizeString();
        String s = "aab";
        System.out.println(obj.reorganizeString(s));
    }
}
