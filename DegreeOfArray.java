import java.util.Arrays;

public class DegreeOfArray {

    public int findShortestSubArray(int[] nums) {
        int degree = 1;
        // Arrays.sort(nums);
        int currDegree = 1;
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] != nums[i + 1]) {
                degree = Math.max(degree, currDegree);
                currDegree = 1;
            } else {
                currDegree += 1;
            }
            i += 1;
        }
        degree = Math.max(degree, currDegree);
        System.out.println(degree);
        return degree;
    }

    public static void main(String[] args) {
        DegreeOfArray obj = new DegreeOfArray();
        int[] nums = { 1, 2, 2, 3, 1, 4, 2 };
        obj.findShortestSubArray(nums);

    }
}
