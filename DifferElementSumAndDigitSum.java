public class DifferElementSumAndDigitSum {

    public int differenceOfSum(int[] nums) {
        int numSum = 0;
        int digitSum = 0;
        for (int num : nums) {
            numSum += num;
            while (num > 0) {
                digitSum += num % 10;
                num /= 10;
            }
        }
        return Math.abs(numSum - digitSum);
    }

    public static void main(String[] args) {
        DifferElementSumAndDigitSum obj = new DifferElementSumAndDigitSum();
        int[] nums = { 1, 15, 6, 3 };
        System.out.println(obj.differenceOfSum(nums));
    }

}
