public class NumberOfSubarraysThatMatchPatternI {

    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int count = 0;
        // Lets bruteforce our way out by checking from each indexes
        for (int i = 0; i < nums.length; i++) {
            int patternIdx = 0;
            int idx = i;
            while (patternIdx < pattern.length && idx + 1 < nums.length) {
                if (pattern[patternIdx] == 1) {
                    if (nums[idx + 1] <= nums[idx]) {
                        break;
                    }
                } else if (pattern[patternIdx] == -1) {
                    if (nums[idx + 1] >= nums[idx]) {
                        break;
                    }
                } else {
                    if (nums[idx + 1] != nums[idx]) {
                        break;
                    }
                }
                idx++;
                patternIdx++;
            }
            if (patternIdx == pattern.length) {
                // means conditions were satisfied
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfSubarraysThatMatchPatternI obj = new NumberOfSubarraysThatMatchPatternI();
        int[] nums = { 1, 4, 4, 1, 3, 5, 5, 3 };
        int[] pattern = { 1, 0, -1 };
        System.out.println(obj.countMatchingSubarrays(nums, pattern));
    }
}
