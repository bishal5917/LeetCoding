import java.util.ArrayList;
import java.util.List;

// O(nlog(n)) time and O(n) space
public class TwoSumSorted {

    public int[] twoSum(int[] numbers, int target) {
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = numbers.length - 1;

        while (i <= j) {
            if (numbers[i] + numbers[j] == target) {
                ans.add(i + 1);
                ans.add(j + 1);
                break;
            } else if (numbers[i] + numbers[j] > target) {
                j -= 1;
            } else {
                i += 1;
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int target = 9;
        int[] nums = { 2, 7, 11, 15 };
        TwoSumSorted obj = new TwoSumSorted();
        obj.twoSum(nums, target);
    }

}
