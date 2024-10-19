public class MaxProductDifference {

    public int maxProductDifference(int[] nums) {
        int maxIdx = -1;
        int minIdx = -1;
        int max = 0;
        int secondMax = 0;
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
            if (nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > secondMax && i != maxIdx) {
                secondMax = nums[i];
            }
            if (nums[i] < secondMin && i != minIdx) {
                secondMin = nums[i];
            }
        }
        System.out.println(max + "---" + secondMax);
        System.out.println(min + "---" + secondMin);
        return (max * secondMax) - (min * secondMin);
    }

    public static void main(String[] args) {
        MaxProductDifference obj = new MaxProductDifference();
        int[] nums = { 1, 6, 7, 5, 2, 4, 10, 6, 4 };
        System.out.println(obj.maxProductDifference(nums));
    }
}
