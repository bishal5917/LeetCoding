
public class CountEqualAndDivisiblePairsInArray {

    public int countPairs(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = nums[i];
                int b = nums[j];
                if (i != j && a == b && (i * j) % k == 0) {
                    count++;
                }
            }
        }
        return count / 2;
    }

    public static void main(String[] args) {
        CountEqualAndDivisiblePairsInArray obj = new CountEqualAndDivisiblePairsInArray();
        int[] nums = { 3, 1, 2, 2, 2, 1, 3 };
        int k = 2;
        System.out.println(obj.countPairs(nums, k));
    }
}
