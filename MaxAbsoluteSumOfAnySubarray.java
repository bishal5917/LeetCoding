public class MaxAbsoluteSumOfAnySubarray {

    public int maxAbsoluteSum(int[] nums) {
        return Math.max(kadaneÁlgorithm(nums, true), Math.abs(kadaneÁlgorithm(nums, false)));
    }

    private int kadaneÁlgorithm(int[] nums, boolean forMaxSum) {
        int finalSum = 0;
        int runningSum = 0;
        for (int num : nums) {
            int added = runningSum + num;
            boolean firstCase = forMaxSum ? num > added : num < added;
            if (firstCase) {
                // start new sum
                runningSum = num;
            } else {
                // else keep adding
                runningSum += num;
            }
            finalSum = forMaxSum == true ? Math.max(finalSum, runningSum) : Math.min(finalSum, runningSum);
        }
        return finalSum;
    }

    public static void main(String[] args) {
        MaxAbsoluteSumOfAnySubarray obj = new MaxAbsoluteSumOfAnySubarray();
        int[] nums = { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println(obj.maxAbsoluteSum(nums));
    }
}
