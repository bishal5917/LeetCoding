public class MinimumOperationToMakeDivisibleByThree {

    public int minimumOperations(int[] nums) {
        int ops = 0;
        for (int num : nums) {
            ops += Math.min(num % 3, 3 - (num % 3));
        }
        return ops;
    }

    public static void main(String[] args) {
        MinimumOperationToMakeDivisibleByThree obj = new MinimumOperationToMakeDivisibleByThree();
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(obj.minimumOperations(nums));
    }
}
