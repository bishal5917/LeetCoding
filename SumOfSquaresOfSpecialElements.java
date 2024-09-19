public class SumOfSquaresOfSpecialElements {

    public int sumOfSquares(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums.length % (i + 1) == 0) {
                sum += (nums[i] * nums[i]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        SumOfSquaresOfSpecialElements obj = new SumOfSquaresOfSpecialElements();
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(obj.sumOfSquares(nums));
    }
}
