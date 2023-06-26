
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                for (int k = 2; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0 && nums[i] != nums[j] && nums[j] != nums[k]
                            && nums[j] != nums[k]) {
                        System.out.println("True");
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {

        List<Integer> numsList = Arrays.asList(-1, 0, 1, 2, -1, -4);
        int[] nums = new int[numsList.size()];
        for (int i = 0; i < numsList.size(); i++) {
            nums[i] = numsList.get(i);
        }

        ThreeSum tsum = new ThreeSum();
        tsum.threeSum(nums);

    }
}
