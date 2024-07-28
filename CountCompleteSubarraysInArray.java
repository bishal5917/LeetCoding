import java.util.HashMap;
import java.util.HashSet;

public class CountCompleteSubarraysInArray {

    public int countCompleteSubarrays(int[] nums) {
        int count = 0;
        int i = 0;
        int j = 0;
        HashSet<Integer> uniqs = new HashSet<>();
        for (int num : nums) {
            uniqs.add(num);
        }
        int totalDistinct = uniqs.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        // TIME TO SLIDE THE WINDOW
        while (j < n) {
            // else we try to include from the right
            int num = nums[j++];
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            while (map.size() == totalDistinct) {
                count += n - j + 1;
                // we try to remove from left,gotta count
                int curr = nums[i++];
                if (map.get(curr) > 1) {
                    map.put(curr, map.get(curr) - 1);
                } else {
                    map.remove(curr);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountCompleteSubarraysInArray obj = new CountCompleteSubarraysInArray();
        int[] nums = { 1, 3, 1, 2, 2 };
        System.out.println(obj.countCompleteSubarrays(nums));
    }
}
