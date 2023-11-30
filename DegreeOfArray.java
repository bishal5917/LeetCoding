import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class DegreeOfArray {

    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        HashMap<Integer, Integer> firstSeenIdxs = new HashMap<>();
        HashMap<Integer, Integer> lastSeenIdxs = new HashMap<>();
        AtomicInteger minSubarrayLength = new AtomicInteger(50001);
        AtomicInteger maxDegree = new AtomicInteger(Integer.MIN_VALUE);
        for (int i = 0; i < nums.length; i++) {
            int item = nums[i];
            if (counts.containsKey(item)) {
                int previousVal = counts.get(item);
                int newVal = previousVal + 1;
                maxDegree.set( Math.max(maxDegree.get(), newVal));
                counts.put(item, newVal);
                lastSeenIdxs.put(item, i);
            } else {
                counts.put(item, 1);
                firstSeenIdxs.put(item, i);
                lastSeenIdxs.put(item, i);
            }
        }
        System.out.println(maxDegree);
        System.out.println(counts);
        System.out.println(firstSeenIdxs);
        System.out.println(lastSeenIdxs);
        counts.forEach((key, value) -> {
            if (value == maxDegree.get()) {
                // differ first and last seen idx
                int diff = lastSeenIdxs.get(key) - firstSeenIdxs.get(key) + 1;
                minSubarrayLength.set(Math.min(minSubarrayLength.get(), diff));
            }
        });
        System.out.println(minSubarrayLength.get()==50001 ? 1 : minSubarrayLength.get());
        return minSubarrayLength.get()==50001 ? 1 : minSubarrayLength.get();
    }

    public static void main(String[] args) {
        DegreeOfArray obj = new DegreeOfArray();
        int[] nums = { 1};
        obj.findShortestSubArray(nums);
    }
}
