import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> dubs = new ArrayList<>();
        HashMap<Integer, Integer> bucket = new HashMap<>();
        for (int num : nums) {
            if (bucket.get(num) == null) {
                bucket.put(num, 1);
            } else {
                // else it aleady appeared once,so its a duplicate
                // Every number either occurs once or twice
                dubs.add(num);
            }
        }
        return dubs;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        FindAllDuplicatesInAnArray obj = new FindAllDuplicatesInAnArray();
        List<Integer> ans = obj.findDuplicates(nums);
        System.out.println(ans);
    }

}
