import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LonelyNumbersInArray {

    public List<Integer> findLonely(int[] nums) {
        List<Integer> lonelyNums = new ArrayList<>();
        // Bucket for counting
        HashMap<Integer, Integer> bucket = new HashMap<>();
        for (int num : nums) {
            if (bucket.get(num) == null) {
                bucket.put(num, 1);
            } else {
                int prev = bucket.get(num);
                bucket.put(num, prev + 1);
            }
        }
        // Now go through the hashmap and add the num to the lonely nums if its empty

        for (Map.Entry<Integer, Integer> entry : bucket.entrySet()) {
            int currKey = entry.getKey();
            if (bucket.get(currKey) == 1) {
                // check if we have its neighbours or not
                if (bucket.get(currKey - 1) == null && bucket.get(currKey + 1) == null) {
                    // means its lonely 😭,add it
                    lonelyNums.add(currKey);
                }
            }
        }
        return lonelyNums;
    }

    public static void main(String[] args) {
        LonelyNumbersInArray obj = new LonelyNumbersInArray();
        int[] nums = { 10, 6, 5, 8 };
        System.out.println(obj.findLonely(nums));
    }

}
