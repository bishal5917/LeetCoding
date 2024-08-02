import java.util.ArrayList;
import java.util.List;

public class AllDivisionsWithHighestScoreOfBinaryArray {

    public List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int maxScore = 0;
        // We count left zeroes and right ones
        int zeros = 0;
        int ones = 0;
        // first its gonna be right, so count ones in right
        for (int num : nums) {
            if (num == 1) {
                maxScore++;
                ones++;
            }
        }
        ans.add(0);
        // Now we gotta divide
        for (int i = 0; i < nums.length; i++) {
            // move this to the left,count 0 if its that
            if (nums[i] == 0) {
                zeros++;
            }
            if (nums[i] == 1) {
                ones--;
            }
            if (zeros + ones == maxScore) {
                ans.add(i + 1);
            }
            if (zeros + ones > maxScore) {
                maxScore = zeros + ones;
                ans = new ArrayList<>();
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        AllDivisionsWithHighestScoreOfBinaryArray obj = new AllDivisionsWithHighestScoreOfBinaryArray();
        int[] nums = { 0, 0, 1, 0 };
        System.out.println(obj.maxScoreIndices(nums));
    }
}
