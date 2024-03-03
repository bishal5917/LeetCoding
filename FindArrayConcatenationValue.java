public class FindArrayConcatenationValue {

    public long findTheArrayConcVal(int[] nums) {
        long ans = 0;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            String val = "0";
            val = val + nums[i];
            val = val + nums[j];
            System.out.println(val);
            ans = ans + Integer.valueOf(val);
            i += 1;
            j -= 1;
        }
        // if length is odd,add the remaining last value
        if (nums.length % 2 != 0)
            ans = ans + nums[i];
        return ans;
    }

    public static void main(String[] args) {
        FindArrayConcatenationValue obj = new FindArrayConcatenationValue();
        int[] nums = { 5, 14, 13, 8, 12 };
        System.out.println(obj.findTheArrayConcVal(nums));
    }

}
