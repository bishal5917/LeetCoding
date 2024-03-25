public class AntOnTheBoundary {

    public int returnToBoundaryCount(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        // Now count the zeroes
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                count += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        AntOnTheBoundary obj = new AntOnTheBoundary();
        int[] nums = { 2, 3, -5 };
        System.out.println(obj.returnToBoundaryCount(nums));
    }
}
