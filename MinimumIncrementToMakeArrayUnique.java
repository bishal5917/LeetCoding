import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique {

    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int incs = 0;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            if (curr <= prev) {
                // we gotta add diff
                int diff = prev + 1 - curr;
                incs += diff;
                curr += diff;
            }
            prev = curr;
        }
        return incs;
    }

    // TIME LIMIT EXCEEDED on TEST CASE 56 🤣
    // public int minIncrementForUnique(int[] nums) {
    // HashSet<Integer> set = new HashSet<>();
    // Arrays.sort(nums);
    // int incs = 0;
    // for (int i = nums.length - 1; i >= 0; i--) {
    // int num = nums[i];
    // if (set.contains(num)) {
    // // we increment till we can't find it in nums
    // while (set.contains(num)) {
    // incs++;
    // num++;
    // }
    // }
    // set.add(num);
    // }
    // return incs;
    // }

    // MAIN INTUITION
    // 3,2,1,2,1,7
    // 1,1,2,2,3,7
    // 1,2,3,4,5,7
    // increments = 2 +2 + 2

    public static void main(String[] args) {
        MinimumIncrementToMakeArrayUnique obj = new MinimumIncrementToMakeArrayUnique();
        int[] nums = { 3, 2, 1, 2, 1, 7 };
        System.out.println(obj.minIncrementForUnique(nums));
    }
}
