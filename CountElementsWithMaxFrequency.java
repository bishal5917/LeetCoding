import java.util.HashMap;
import java.util.Map;

public class CountElementsWithMaxFrequency {

    public int maxFrequencyElements(int[] nums) {
        // Lets just count and keep tracking the max frequency
        int maxFreq = 0;
        HashMap<Integer, Integer> bucket = new HashMap<>();
        for (int num : nums) {
            if (bucket.get(num) == null) {
                maxFreq = Math.max(maxFreq, 1);
                bucket.put(num, 1);
            } else {
                int prev = bucket.get(num);
                bucket.put(num, prev + 1);
                maxFreq = Math.max(maxFreq, prev + 1);
            }
        }
        // Now just count the one with maxFreq
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : bucket.entrySet()) {
            if (entry.getValue() == maxFreq) {
                count += 1;
            }
        }
        return count * maxFreq;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 3, 1, 4 };
        CountElementsWithMaxFrequency obj = new CountElementsWithMaxFrequency();
        System.out.println(obj.maxFrequencyElements(nums));
    }

}
