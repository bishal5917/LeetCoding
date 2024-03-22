public class MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 1) {
            return (double) nums[0];
        }
        double maxAvg = 0;
        // lets maintain a window of size k
        long currSum = 0;
        int i = 0;
        int j = 0;
        while (j < nums.length && j < k) {
            currSum += nums[j];
            j += 1;
        }
        // Update the maxAvg
        double average = (double) currSum / (double) k;
        if (maxAvg == 0) {
            if (Math.abs(average) > maxAvg) {
                maxAvg = average;
            }
        } else {
            maxAvg = Math.max(maxAvg, average);
        }
        // NOW TIME TO SLIDE THE WINDOW
        while (j < nums.length) {
            currSum -= nums[i];
            currSum += nums[j];
            average = (double) currSum / (double) k;
            if (maxAvg == 0) {
                if (Math.abs(average) > maxAvg) {
                    maxAvg = average;
                }
            } else {
                maxAvg = Math.max(maxAvg, average);
            }
            i += 1;
            j += 1;
        }
        return maxAvg;
    }

    public static void main(String[] args) {
        MaximumAverageSubarrayI obj = new MaximumAverageSubarrayI();
        int[] nums = { 4, 0, 4, 3, 3 };
        int k = 5;
        System.out.println(obj.findMaxAverage(nums, k));
    }
}
