import java.util.HashMap;

public class NRepeatedElement {

    public int repeatedNTimes(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int item : nums) {
            if (countMap.containsKey(item)) {
                int val = countMap.get(item);
                countMap.put(item, val + 1);
            } else {
                countMap.put(item, 1);
            }
        }

        for (int key : countMap.keySet()) {
            if (countMap.get(key) == nums.length / 2) {
                return key;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 3 };
        NRepeatedElement obj = new NRepeatedElement();
        obj.repeatedNTimes(arr);
    }
}
