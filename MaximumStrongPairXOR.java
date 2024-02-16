import java.util.ArrayList;
import java.util.List;

public class MaximumStrongPairXOR {

    public int maximumStrongPairXor(int[] nums) {
        return findMaximumStrongPairRecursiveHelper(nums, 0, new ArrayList<>(), 0);
    }

    private int findMaximumStrongPairRecursiveHelper(int[] nums, int maxXOR, List<Integer> pair, int index) {

        if (pair.size() == 2) {
            System.out.println(pair);
            int a = pair.get(0);
            int b = pair.get(1);
            if (Math.abs(a - b) <= Math.min(a, b)) {
                // means a strong pair is found
                // calculate the xor and check if its max or not
                // if its max set it and return
                int currXOR = a ^ b; // (CARET OPERATOR IS USED TO FIND XOR)
                maxXOR = Math.max(maxXOR, currXOR);
            }
            return maxXOR;
        }
        for (int i = index; i < nums.length; i++) {
            pair.add(nums[i]);
            maxXOR = findMaximumStrongPairRecursiveHelper(nums, maxXOR, pair, i);
            pair.remove(pair.size() - 1);
        }
        return maxXOR;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        MaximumStrongPairXOR obj = new MaximumStrongPairXOR();
        int ans = obj.maximumStrongPairXor(nums);
        System.out.println(ans);
    }

}