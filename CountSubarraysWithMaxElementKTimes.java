public class CountSubarraysWithMaxElementKTimes {

    public long countSubarrays(int[] nums, int k) {
        long count = 0;
        int maxNum = Integer.MIN_VALUE;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        // tracking the occurence of max currently
        long currentOccurence = 0;
        // USING THE SLIDING WINDOW APPROACH
        int i = 0;
        int j = 0;
        while (i < nums.length) {
            if (currentOccurence < k) {
                if (j < nums.length) {
                    if (nums[j] == maxNum) {
                        currentOccurence += 1;
                    }
                    j += 1;
                } else {
                    break;
                }
            } else {
                // else track the subsets
                count += nums.length - j + 1;
                if (nums[i] == maxNum) {
                    currentOccurence -= 1;
                }
                i += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountSubarraysWithMaxElementKTimes obj = new CountSubarraysWithMaxElementKTimes();
        int[] nums = { 1, 3, 2, 3, 3 };
        System.out.println(obj.countSubarrays(nums, 2));
    }
}
