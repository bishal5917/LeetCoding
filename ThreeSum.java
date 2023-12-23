import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

//COMPLEXITY ANALYSIS
//Constant Space O(1)
//O(nlogn) -> For Sorting
//O(n.2) -> For Double loop
//overall -> O(nlogn)+O(n.2) = O(n.2) time

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sumTriplets = new ArrayList<>();
        Arrays.sort(nums);

        // check for every if there is a three sum possible
        int outer = 0;
        while (outer < nums.length) {
            if (outer > 0 && nums[outer] == nums[outer - 1]) {
                outer += 1;
                continue;
            }
            int i = outer + 1;
            int j = nums.length - 1;
            while (i < j) {
                int currSum = nums[outer] + nums[i] + nums[j];
                if (currSum > 0) {
                    j = j - 1;
                } else if (currSum < 0) {
                    i = i + 1;
                } else {
                    List<Integer> sumTriplet = new ArrayList<>();
                    sumTriplet.add(nums[outer]);
                    sumTriplet.add(nums[i]);
                    sumTriplet.add(nums[j]);
                    sumTriplets.add(sumTriplet);
                    i += 1;
                    while (nums[i] == nums[i - 1] && i < j) {
                        i += 1;
                    }
                }
            }
            outer += 1;
        }
        System.out.println(sumTriplets);
        return sumTriplets;
    }

    public static void main(String[] args) {
        ThreeSum obj = new ThreeSum();
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        obj.threeSum(nums);
    }
}
