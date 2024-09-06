public class FindSmallestDivisorGivenAThreshold {

    public int smallestDivisor(int[] nums, int threshold) {
        // WE USE BINARY SEARCH 🔥
        int minDivisor = Integer.MAX_VALUE;
        int left = 1;
        int right = 1000000;
        while (left <= right) {
            int mid = (left + right) / 2;
            int val = divideAndSum(nums, mid);
            if (val > threshold) {
                // if its greater than threshold, then we try increase the divisor
                left = mid + 1;
            } else {
                // if its less than or equal to threshold,we track the value
                // and try tp decrease the divisor
                minDivisor = Math.min(minDivisor, mid);
                right = mid - 1;
            }
        }
        return minDivisor;
    }

    private int divideAndSum(int[] nums, int divisor) {
        int sum = 0;
        for (int dividend : nums) {
            // Perform division and round up to the nearest integer
            int result = (int) Math.ceil((double) dividend / divisor);
            sum += result;
        }
        return sum;
    }

    public static void main(String[] args) {
        FindSmallestDivisorGivenAThreshold obj = new FindSmallestDivisorGivenAThreshold();
        int[] nums = { 44, 22, 33, 11, 1 };
        int threshold = 5;
        System.out.println(obj.smallestDivisor(nums, threshold));
    }
}
