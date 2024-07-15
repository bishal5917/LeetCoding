import java.util.Arrays;

public class SumOfEvenNumberAfterQueries {

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] sums = new int[queries.length];
        // Lets first get the even sums
        int sum = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                sum += num;
            }
        }
        // Applying the queries and calculating the sum
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int idx = query[1];
            int val = query[0];
            int prevVal = nums[idx];
            int newVal = prevVal + val;
            nums[idx] = newVal;
            // Now we remove previous val if it was even
            if (prevVal % 2 == 0) {
                sum -= prevVal;
            }
            // And we add new val if its even
            if (newVal % 2 == 0) {
                sum += newVal;
            }
            sums[i] = sum;
        }
        return sums;
    }

    public static void main(String[] args) {
        SumOfEvenNumberAfterQueries obj = new SumOfEvenNumberAfterQueries();
        int[] nums = { 1, 2, 3, 4 };
        int[][] queries = { { 1, 0 }, { -3, 1 }, { -4, 0 }, { 2, 3 } };
        int[] ans = obj.sumEvenAfterQueries(nums, queries);
        System.out.println(Arrays.toString(ans));
    }
}
