import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        List<String> kFrequentWords = new ArrayList<>();
        // Lets count them and put in a max heap
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        // Create a priority queue with custom comparator
        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(
                (a, b) -> {
                    // Compare values first
                    if (a.getValue() != b.getValue()) {
                        return b.getValue() - a.getValue();
                    }
                    // If values are equal, compare keys lexicographically
                    return a.getKey().compareTo(b.getKey()); // Return lexically smallest key
                });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            heap.offer(entry);
        }
        // Now remove the top k entries and add to the ans
        for (int i = 0; i < k; i++) {
            Map.Entry<String, Integer> entry = heap.poll();
            kFrequentWords.add(entry.getKey());
        }
        System.out.println(map);
        return kFrequentWords;
    }

    public static void main(String[] args) {
        TopKFrequentWords obj = new TopKFrequentWords();
        String[] words = { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" };
        System.out.println(obj.topKFrequent(words, 4));
    }
}
