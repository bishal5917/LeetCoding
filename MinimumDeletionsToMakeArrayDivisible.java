import java.util.Arrays;

public class MinimumDeletionsToMakeArrayDivisible {

    public int minOperations(int[] nums, int[] numsDivide) {
        int ops = 0;
        Arrays.sort(nums);
        int gcd = getGcd(numsDivide);
        for (int num : nums) {
            if (gcd % num == 0) {
                return ops;
            }
            ops += 1;
        }
        return -1;
    }

    // Function to find gcd of array of numbers
    public int getGcd(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = gcd(result, nums[i]);

            // If the GCD becomes 1, we can return 1 immediately
            if (result == 1) {
                return 1;
            }
        }
        return result;
    }

    // Function to return gcd of a and b
    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        MinimumDeletionsToMakeArrayDivisible obj = new MinimumDeletionsToMakeArrayDivisible();
        int[] nums = { 2, 3, 2, 4, 3 };
        int[] numsDivide = { 9, 6, 9, 3, 15 };
        System.out.println(obj.minOperations(nums, numsDivide));
    }
}
