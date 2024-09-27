import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Item {
    int val;
    int count;

    public Item(int val, int count) {
        this.val = val;
        this.count = count;
    }
}

public class SortArrayByIncreasingFrequeny {

    public int[] frequencySort(int[] nums) {
        // Lets count using hashmap
        List<Item> sorted = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        System.out.println(map);
        // Now add to sorted and sort
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sorted.add(new Item(entry.getKey(), entry.getValue()));
        }
        // Now sort based on comparators and add back to the original nums
        Collections.sort(sorted, new Comparator<Item>() {
            @Override
            public int compare(Item a, Item b) {
                // First, compare based on frequency (increasing order)
                if (a.count != b.count) {
                    return Integer.compare(a.count, b.count);
                }
                // If frequencies are the same, compare based on value (decreasing order)
                return Integer.compare(b.val, a.val);
            }
        });
        // Now add back to nums
        int idx = 0;
        for (Item item : sorted) {
            int count = item.count;
            while (count > 0) {
                nums[idx++] = item.val;
                count--;
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }

    public static void main(String[] args) {
        SortArrayByIncreasingFrequeny obj = new SortArrayByIncreasingFrequeny();
        int[] nums = { 1, 1, 2, 2, 2, 3 };
        obj.frequencySort(nums);
    }
}
