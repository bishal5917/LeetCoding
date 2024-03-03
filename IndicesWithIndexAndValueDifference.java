import java.util.Arrays;

public class IndicesWithIndexAndValueDifference {

    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        // Using the min and max technique
        int minIdx = 0;
        int maxIdx = 0;
        for (int i = indexDifference; i < nums.length; i++) {
            if (nums[i - indexDifference] < nums[minIdx])
                minIdx = i - indexDifference;
            if (nums[i - indexDifference] > nums[maxIdx])
                maxIdx = i - indexDifference;
            if (nums[i] - nums[minIdx] >= valueDifference)
                return new int[] { minIdx, i };
            if (nums[maxIdx] - nums[i] >= valueDifference)
                return new int[] { maxIdx, i };
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        IndicesWithIndexAndValueDifference obj = new IndicesWithIndexAndValueDifference();
        int[] nums = { 5, 1, 4, 1 };
        int indexDifference = 2;
        int valueDifference = 4;
        int[] ans = obj.findIndices(nums, indexDifference, valueDifference);
        System.out.println(Arrays.toString(ans));
    }
}