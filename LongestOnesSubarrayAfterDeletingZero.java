public class LongestOnesSubarrayAfterDeletingZero {

    public int longestSubarray(int[] nums) {
        int currLongest = 0;
        int l = 0;
        int r = 0;
        int zeroesTillNow = 0;
        while (l < nums.length && r < nums.length) {
            if (nums[r] == 1) {
                currLongest = Math.max(r - l + 1 - zeroesTillNow, currLongest);
                r += 1;
            } else {
                zeroesTillNow += 1;
                if (zeroesTillNow > 1) {
                    while (l < nums.length && nums[l] != 0) {
                        l += 1;
                    }
                    l += 1;
                    zeroesTillNow -= 1;
                }
                currLongest = Math.max(r - l + 1 - zeroesTillNow, currLongest);
                r += 1;
            }
        }
        // because we gotta delete at least one element
        if (zeroesTillNow == 0) {
            currLongest = currLongest - 1;
        }
        System.out.println(zeroesTillNow);
        return currLongest;
    }

    public static void main(String[] args) {
        LongestOnesSubarrayAfterDeletingZero obj = new LongestOnesSubarrayAfterDeletingZero();
        int[] nums = { 0, 1, 1, 1, 0, 1, 1, 0, 1 };
        System.out.println(obj.longestSubarray(nums));
    }
}
