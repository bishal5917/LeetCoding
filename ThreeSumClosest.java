import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = target;
        int currdiff = Integer.MAX_VALUE;

        // check for every if there is a three sum possible
        int outer = 0;
        while (outer < nums.length) {
            int i = outer + 1;
            int j = nums.length - 1;
            while (i < j) {
                int currSum = nums[outer] + nums[i] + nums[j];
                if (currSum > target) {
                    if (Math.abs(currSum - target) < currdiff) {
                        closestSum = currSum;
                        currdiff = Math.abs(currSum - target);
                    }
                    j = j - 1;
                } else if (currSum < target) {
                    if (Math.abs(currSum - target) < currdiff) {
                        closestSum = currSum;
                        currdiff = Math.abs(currSum - target);
                    }
                    i = i + 1;
                } else {
                    return target;
                }
            }
            outer += 1;
        }
        return closestSum;
    }

    public static void main(String[] args) {
        ThreeSumClosest obj = new ThreeSumClosest();
        int[] nums = { 0, 0, 0 };
        int target = 1;
        int ans = obj.threeSumClosest(nums, target);
        System.out.println(ans);
    }
}
