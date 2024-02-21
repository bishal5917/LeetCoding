import java.util.HashSet;

public class KeepMultiplyingFoundValuesByTwo {

    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        // using set to retrive efficiently
        while (numSet.contains(original)) {
            original = 2 * original;
        }
        return original;
    }

    public static void main(String[] args) {
        KeepMultiplyingFoundValuesByTwo obj = new KeepMultiplyingFoundValuesByTwo();
        int[] nums = { 5, 3, 6, 1, 12 };
        System.out.println(obj.findFinalValue(nums, 3));
    }
}
