public class CountSubarraysWithScoreLessThank {

    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long count = 0;
        int l = 0;
        int r = 0;
        long sum = 0;
        while (r < n) {
            sum += nums[r];
            while (sum * (r - l + 1) >= k) {
                // slide from the left and decrease score
                sum -= nums[l];
                l += 1;
            }
            count += (r - l + 1);
            r += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        CountSubarraysWithScoreLessThank obj = new CountSubarraysWithScoreLessThank();
        int[] nums = { 1, 1, 1 };
        long k = 5;
        System.out.println(obj.countSubarrays(nums, k));
    }
}
