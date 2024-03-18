public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k) {
        int longest = 0;
        int flips = k;
        int i = 0;
        int j = 0;
        // NOW USING THE SLIDING WINDOW TECHNIQUE
        while (i < nums.length && j < nums.length) {
            if (nums[j] == 1) {
                longest = Math.max(longest, j - i + 1);
                j += 1;
            } else {
                // If we have no flips present
                if (flips <= 0) {
                    // slide from the left
                    if (nums[i] == 0) {
                        i += 1;
                        flips += 1;
                    } else {
                        i += 1;
                    }
                } else {
                    // keep incrementing right
                    longest = Math.max(longest, j - i + 1);
                    flips -= 1;
                    j += 1;
                }
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesIII obj = new MaxConsecutiveOnesIII();
        int[] nums = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
        int k = 3;
        System.out.println(obj.longestOnes(nums, k));
    }
}
