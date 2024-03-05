import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RangeSumOfSortedSubarraySums {

    public int rangeSum(int[] nums, int n, int left, int right) {
        long sum = 0;
        // Now lets first calculate the subarray sum
        List<Integer> subArraySums = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int currSum = nums[i];
            subArraySums.add(currSum);
            for (int j = i + 1; j < nums.length; j++) {
                currSum += nums[j];
                subArraySums.add(currSum);
            }
        }
        // System.out.println(subArraySums);
        Collections.sort(subArraySums);
        // Now just add the value from left to right in the sum
        for (int i = left - 1; i < right; i++) {
            sum = sum + subArraySums.get(i);
        }
        return (int) modularExponentiation(sum);
    }

    private long modularExponentiation(long num) {
        int m = 1000000007;
        return (num % m + m) % m;
    }

    public static void main(String[] args) {
        RangeSumOfSortedSubarraySums obj = new RangeSumOfSortedSubarraySums();
        int[] nums = { 1, 2, 3, 4 };
        int n = 4;
        int left = 1;
        int right = 5;
        System.out.println(obj.rangeSum(nums, n, left, right));
    }
}
