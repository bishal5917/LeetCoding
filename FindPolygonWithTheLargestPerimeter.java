import java.util.Arrays;

public class FindPolygonWithTheLargestPerimeter {

    public long largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long largest = -1;
        // Lets sort and find the prefix sum
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(prefixSum));
        // Now for to become a polygon its prefixsum must be strictly greater than the
        // curr
        for (int i = 1; i < nums.length; i++) {
            // >=2 because at least 3 sides are needed
            if (i >= 2 && prefixSum[i - 1] > nums[i]) {
                long perimeter = prefixSum[i - 1] + nums[i];
                largest = Math.max(largest, perimeter);
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        FindPolygonWithTheLargestPerimeter obj = new FindPolygonWithTheLargestPerimeter();
        int[] nums = { 1, 12, 1, 2, 5, 50, 3 };
        System.out.println(obj.largestPerimeter(nums));
    }

}
