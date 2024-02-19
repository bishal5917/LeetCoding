import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LeastUniquesAfterKRemovals {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // Lets keep track of how many integers we have
        HashMap<Integer, Integer> bucket = new HashMap<>();
        for (int item : arr) {
            if (bucket.get(item) == null) {
                bucket.put(item, 1);
            } else {
                int count = bucket.get(item);
                bucket.put(item, count + 1);
            }
        }
        // Now,gotta sort the hashmap based on the values in ascending order
        Map<Integer, Integer> sortedBucket = sortMapBasedUponValues(bucket);

        // Now iterate over the map and keep removing the elements one by one
        for (Map.Entry<Integer, Integer> entry : sortedBucket.entrySet()) {
            if (k == 0) {
                break;
            }
            int val = sortedBucket.get(entry.getKey());
            if (val > 0) {
                // just removing the values based upon k(k=operations)
                int leastOne = Math.min(k, val);
                if (leastOne == k) {
                    sortedBucket.put(entry.getKey(), val - k);
                    k = 0;
                } else {
                    sortedBucket.put(entry.getKey(), 0);
                    k = k - val;
                }

            }
        }

        // Now iterate over the map and count the non-zero values
        int uniqueCount = 0;
        for (Map.Entry<Integer, Integer> entry : sortedBucket.entrySet()) {
            if (sortedBucket.get(entry.getKey()) != 0) {
                uniqueCount += 1;
            }
        }
        return uniqueCount;
    }

    private Map<Integer, Integer> sortMapBasedUponValues(Map<Integer, Integer> bucket) {
        // Convert HashMap entries to a List
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(bucket.entrySet());

        // Use Collections.sort() with a custom Comparator to sort by values
        Collections.sort(entryList, Map.Entry.comparingByValue());

        // Create a new LinkedHashMap to maintain the order
        Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    public static void main(String[] args) {
        int[] tasks = { 4, 3, 1, 1, 3, 3, 2 };
        int k = 3;
        LeastUniquesAfterKRemovals obj = new LeastUniquesAfterKRemovals();
        System.out.println(obj.findLeastNumOfUniqueInts(tasks, k));
    }
}
