public class MaximumScoreOfAGoodSubarray {

    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int min = nums[k];
        int score = nums[k];
        // we go left or right from k
        // starting point gonna be k
        int l = k;
        int r = k;
        while (l > 0 || r < n - 1) {
            // Lets expand either left or right
            // expand towards the larger side
            // check left and right accordingly
            // we can go either left or right
            int left = l > 0 ? nums[l - 1] : 0;
            int right = r < n - 1 ? nums[r + 1] : 0;
            if (left > right) {
                // update the min if its min
                min = Math.min(left, min);
                l -= 1;
            } else {
                // update the min if its min
                min = Math.min(right, min);
                r += 1;
            }
            // update the score
            score = Math.max(score, min * (r - l + 1));
        }
        return score;
    }

    public static void main(String[] args) {
        MaximumScoreOfAGoodSubarray obj = new MaximumScoreOfAGoodSubarray();
        int[] nums = { 1, 4, 3, 7, 4, 5 };
        int k = 3;
        System.out.println(obj.maximumScore(nums, k));
    }
}
