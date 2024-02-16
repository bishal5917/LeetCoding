import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupSizes {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> groups = new ArrayList<>();
        Map<Integer, List<Integer>> buckets = new HashMap<>();
        int added = 0;
        while (added != groupSizes.length) {
            for (int i = 0; i < groupSizes.length; i++) {
                if (groupSizes[i] == 0) {
                    continue;
                }
                if (buckets.get(groupSizes[i]) != null) {
                    // means theres already a bucket
                    // now check if the capacity is full
                    if (buckets.get(groupSizes[i]).size() == groupSizes[i]) {
                        // means the bucket is full
                        // add it to answer
                        groups.add(new ArrayList<>(buckets.get(groupSizes[i])));
                        // now clear the bucket
                        buckets.get(groupSizes[i]).clear();
                        List<Integer> persons = buckets.get(groupSizes[i]);
                        persons.add(i);
                        added += 1;
                        groupSizes[i] = 0;
                        buckets.put(groupSizes[i], persons);
                    } else {
                        List<Integer> persons = buckets.get(groupSizes[i]);
                        persons.add(i);
                        added += 1;
                        groupSizes[i] = 0;
                        buckets.put(groupSizes[i], persons);
                    }
                } else {
                    buckets.put(groupSizes[i], new ArrayList<>());
                    List<Integer> persons = buckets.get(groupSizes[i]);
                    persons.add(i);
                    added += 1;
                    groupSizes[i] = 0;
                    buckets.put(groupSizes[i], persons);
                }
            }
        }
        // Iterate over the HashMap to add remaining groups
        for (Map.Entry<Integer, List<Integer>> entry : buckets.entrySet()) {
            if (entry.getKey() != 0) {
                groups.add(buckets.get(entry.getKey()));
            }
        }
        System.out.println(buckets);
        return groups;
    }

    public static void main(String[] args) {
        GroupSizes obj = new GroupSizes();
        int[] nums = { 3, 3, 3, 3, 3, 1, 3 };
        List<List<Integer>> ans = obj.groupThePeople(nums);
        System.out.println(ans);
    }
}
