public class SmallestIndexWithEqualValue {

    public int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 10 == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SmallestIndexWithEqualValue obj = new SmallestIndexWithEqualValue();
        int[] nums = { 0, 1, 2 };
        System.out.println(obj.smallestEqual(nums));
    }
}
