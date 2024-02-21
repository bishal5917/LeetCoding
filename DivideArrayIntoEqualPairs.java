import java.util.HashMap;
import java.util.Map;

public class DivideArrayIntoEqualPairs {

    public boolean divideArray(int[] nums) {
        // Lets create a hashmap first
        HashMap<Integer, Integer> bucket = new HashMap<>();
        for (int num : nums) {
            if (bucket.get(num) == null) {
                bucket.put(num, 1);
            } else {
                bucket.put(num, bucket.get(num) + 1);
            }
        }
        // Now lets iterate over the map and check if we have an odd val
        for (Map.Entry<Integer, Integer> entry : bucket.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 3, 2, 2, 2 };
        DivideArrayIntoEqualPairs obj = new DivideArrayIntoEqualPairs();
        System.out.println(obj.divideArray(nums));
    }

}
