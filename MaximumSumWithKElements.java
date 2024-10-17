
public class MaximumSumWithKElements {

    public int maximizeSum(int[] nums, int k) {
        int sum = 0;
        int maxNum = 0;
        // get the maxNum
        for (int num : nums) {
            maxNum = Math.max(num, maxNum);
        }
        // Lets find the max num
        // Now we do the simulation k times
        while (k > 0) {
            sum += maxNum;
            maxNum++;
            k--;
        }
        return sum;
    }

    public static void main(String[] args) {
        MaximumSumWithKElements obj = new MaximumSumWithKElements();
        int[] nums = { 1, 2, 3, 4, 5 };
        int k = 3;
        System.out.println(obj.maximizeSum(nums, k));
    }
}
