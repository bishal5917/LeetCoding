import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfPairsInArray {

    public int[] numberOfPairs(int[] nums) {
        int totalPairs = 0;
        int leftOvers = 0;
        // Lets just create a bucket first
        HashMap<Integer, Integer> bucket = new HashMap<>();
        for (int num : nums) {
            if (bucket.get(num) == null) {
                bucket.put(num, 1);
            } else {
                int prev = bucket.get(num);
                bucket.put(num, prev + 1);
            }
        }
        System.out.println(bucket);
        // Now lets just iterate over the map
        for (Map.Entry<Integer, Integer> entry : bucket.entrySet()) {
            totalPairs = totalPairs + entry.getValue() / 2;
            leftOvers = leftOvers + entry.getValue() % 2;
        }
        int[] ans = { totalPairs, leftOvers };
        return ans;
    }

    public static void main(String[] args) {
        MaximumNumberOfPairsInArray obj = new MaximumNumberOfPairsInArray();
        int[] nums = { 1, 3, 2, 1, 3, 2, 2 };
        int[] ans = obj.numberOfPairs(nums);
        System.out.println(Arrays.toString(ans));
    }
}