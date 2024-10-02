public class MinimumElementAfterReplacementWithDigitSum {

    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            min = Math.min(sum, min);
        }
        return min;
    }

    public static void main(String[] args) {
        MinimumElementAfterReplacementWithDigitSum obj = new MinimumElementAfterReplacementWithDigitSum();
        int[] nums = { 10, 12, 13, 14 };
        System.out.println(obj.minElement(nums));
    }
}
