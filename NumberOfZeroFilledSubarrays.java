public class NumberOfZeroFilledSubarrays {

    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        long count = 0;
        // We gotta count consecutive zeroes
        int idx = 0;
        while (idx < n) {
            if (idx < n && nums[idx] == 0) {
                int left = idx;
                while (idx < n && nums[idx] == 0) {
                    count += (idx - left + 1);
                    idx++;
                }
            }
            idx++;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfZeroFilledSubarrays obj = new NumberOfZeroFilledSubarrays();
        int[] nums = { 0, 0, 0, 2, 0, 0 };
        System.out.println(obj.zeroFilledSubarray(nums));
    }
}
