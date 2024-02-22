import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DivideArrayIntoEqualConsecutiveSets {

    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            // Not possible to divide,just return
            return false;
        }
        Arrays.sort(nums);
        HashMap<Integer, Integer> bucket = new LinkedHashMap<>();
        // Now put in bucket
        for (int num : nums) {
            if (bucket.get(num) == null) {
                bucket.put(num, 1);
            } else {
                bucket.put(num, bucket.get(num) + 1);
            }
        }
        // System.out.println(bucket);
        int grouped = 0;
        while (grouped != nums.length) {
            List<Integer> group = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : bucket.entrySet()) {
                if (group.size() == k) {
                    // means one group is done go for next
                    break;
                }
                if (entry.getValue() > 0) {
                    // Must be in consecutive order
                    if (group.size() == 0 || (group.size() != 0 && entry.getKey() - group.get(group.size() - 1) == 1)) {
                        group.add(entry.getKey());
                        grouped += 1;
                        bucket.put(entry.getKey(), entry.getValue() - 1);
                    } else {
                        return false;
                    }
                }
            }
            // If we couldnot make a group in one pass,return false
            if (group.size() != k) {
                return false;
            }
            // System.out.println(group);
        }
        return true;
    }

    public static void main(String[] args) {
        DivideArrayIntoEqualConsecutiveSets obj = new DivideArrayIntoEqualConsecutiveSets();
        int[] nums = { 1, 1, 2, 2, 3, 3 };
        int k = 2;
        System.out.println(obj.isPossibleDivide(nums, k));
    }

}
