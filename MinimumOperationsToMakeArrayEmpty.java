import java.util.HashMap;
import java.util.Map;

public class MinimumOperationsToMakeArrayEmpty {

    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> bucket = new HashMap<>();

        for (int num : nums) {
            if (bucket.get(num) == null) {
                bucket.put(num, 1);
            } else {
                int prev = bucket.get(num);
                bucket.put(num, prev + 1);
            }
        }
        // Now remove the values greedily
        int operation = 0;
        int removed = 0;
        while (removed != nums.length) {
            for (Map.Entry<Integer, Integer> entry : bucket.entrySet()) {
                if (bucket.get(entry.getKey()) == 0) {
                    continue;
                }
                if (bucket.get(entry.getKey()) == 1) {
                    return -1;
                }
                // If we can remove 3 without leaving any behind,just go for 3
                // else go for 2
                if (bucket.get(entry.getKey()) % 3 == 0) {
                    int toRemove = bucket.get(entry.getKey()) - 3;
                    bucket.put(entry.getKey(), toRemove);
                    operation += 1;
                    removed += 3;
                } else {
                    int toRemove = bucket.get(entry.getKey()) - 2;
                    bucket.put(entry.getKey(), toRemove);
                    operation += 1;
                    removed += 2;
                }
            }
        }
        return operation;
    }

    public static void main(String[] args) {
        MinimumOperationsToMakeArrayEmpty obj = new MinimumOperationsToMakeArrayEmpty();
        int[] nums = { 2, 3, 3, 2, 2, 4, 2, 3, 4 };
        System.out.println(obj.minOperations(nums));
    }
}