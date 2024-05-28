import java.util.HashMap;

public class SubarraysWithKDifferentIntegers {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKHelper(nums, k) - atMostKHelper(nums, k - 1);
    }

    // sliding window
    private int atMostKHelper(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int currentUnique = 0;
        while (r < nums.length) {
            // slide forward from right
            if (map.containsKey(nums[r])) {
                map.put(nums[r], map.get(nums[r]) + 1);
            } else {
                map.put(nums[r], 1);
                currentUnique += 1;
            }
            while (currentUnique > k) {
                // slide from the left
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                    currentUnique -= 1;
                }
                l += 1;
            }
            count += (r - l + 1);
            r += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraysWithKDifferentIntegers obj = new SubarraysWithKDifferentIntegers();
        int[] nums = { 1, 2, 1, 2, 3 };
        int k = 2;
        System.out.println(obj.subarraysWithKDistinct(nums, k));
    }
}
