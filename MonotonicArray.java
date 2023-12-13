public class MonotonicArray {

    public boolean isMonotonic(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int i = 0;
        int wasIncreasing = 0;
        int wasDecreasing = 0;
        while (i < nums.length - 1) {
            if (nums[i] > nums[i + 1]) {
                wasIncreasing += 1;
            } else if (nums[i] < nums[i + 1]) {
                wasDecreasing += 1;
            }
            i += 1;
        }

        return wasIncreasing * wasDecreasing == 0 ? true : false;
    }

    public static void main(String[] args) {
        MonotonicArray obj = new MonotonicArray();
        int[] nums = { 1, 1, 2 };
        Boolean ans = obj.isMonotonic(nums);
        System.out.println(ans);
    }
}
