public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        int count = 0;
        int currentProduct = 1;
        int i = 0;
        int j = 0;
        while (i < nums.length && j < nums.length) {
            currentProduct = currentProduct * nums[j];
            while (currentProduct >= k) {
                currentProduct = currentProduct / nums[i];
                i += 1;
            }
            count += j - i + 1;
            j += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        SubarrayProductLessThanK obj = new SubarrayProductLessThanK();
        int[] nums = { 10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3 };
        int k = 19;
        System.out.println(obj.numSubarrayProductLessThanK(nums, k));
    }
}