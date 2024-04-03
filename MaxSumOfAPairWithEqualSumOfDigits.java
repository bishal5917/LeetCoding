import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxSumOfAPairWithEqualSumOfDigits {

    public int maximumSum(int[] nums) {
        // Lets store the sum of all the digits in a hashmap
        int maxSum = -1;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        // Lets store them here
        for (int num : nums) {
            int digitSum = 0;
            for (int i = num; i > 0; i = i / 10) {
                digitSum += i % 10;
            }
            // Now lets add to the hashmap
            if (map.containsKey(digitSum)) {
                List<Integer> values = map.get(digitSum);
                values.add(num);
                map.put(digitSum, values);
            } else {
                List<Integer> values = new ArrayList<>();
                values.add(num);
                map.put(digitSum, values);
            }
        }
        System.out.println(map);
        // Now time to go for each values and get the max one
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            // sort the values and get the first two
            List<Integer> values = entry.getValue();
            if (values.size() < 2) {
                continue;
            }
            Collections.sort(values, Collections.reverseOrder());
            maxSum = Math.max(maxSum, values.get(0) + values.get(1));
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = { 229, 398, 269, 317, 420, 464, 491, 218, 439, 153, 482, 169, 411, 93, 147, 50, 347, 210, 251, 366,
                401 };
        MaxSumOfAPairWithEqualSumOfDigits obj = new MaxSumOfAPairWithEqualSumOfDigits();
        System.out.println(obj.maximumSum(nums));
    }
}