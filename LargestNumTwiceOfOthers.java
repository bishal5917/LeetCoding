
public class LargestNumTwiceOfOthers {

    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxNumIdx = -1;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                maxNumIdx = i;
                max = nums[i];
            }
        }

        for (int item : nums) {
            if (item * 2 <= max) {
                count += 1;
            } else {
                continue;
            }
        }

        return count == nums.length - 1 ? maxNumIdx : -1;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        LargestNumTwiceOfOthers obj = new LargestNumTwiceOfOthers();
        int ans = obj.dominantIndex(nums);
        System.out.println(ans);
    }

}
