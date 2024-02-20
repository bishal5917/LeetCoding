import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueNumberOfOccurences {

    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> bucket = new HashMap<>();
        for (int num : arr) {
            if (bucket.get(num) == null) {
                bucket.put(num, 1);
            } else {
                int prev = bucket.get(num);
                bucket.put(num, prev + 1);
            }
        }
        // Now lets create a set to check uniques
        HashSet<Integer> occurences = new HashSet<>();
        // lets now iterate over the hashmap
        for (Map.Entry<Integer, Integer> entry : bucket.entrySet()) {
            if (occurences.contains(bucket.get(entry.getKey()))) {
                return false;
            } else {
                occurences.add(bucket.get(entry.getKey()));
            }

        }
        return true;
    }

    public static void main(String[] args) {
        UniqueNumberOfOccurences obj = new UniqueNumberOfOccurences();
        int[] arr = { 1, 2, 2, 1, 1, 3 };
        System.out.println(obj.uniqueOccurrences(arr));
    }

}
