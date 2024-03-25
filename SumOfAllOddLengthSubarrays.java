import java.util.ArrayList;
import java.util.List;

public class SumOfAllOddLengthSubarrays {

    public int sumOddLengthSubarrays(int[] arr) {
        return getOddSubarraySumHelper(arr, 0, 0, new ArrayList<>());
    }

    // USING BRUTEFORCE,RECURSIVE BACKTRACKING APPROACH
    private int getOddSubarraySumHelper(int[] arr, int idx, int sum, List<Integer> subarr) {
        if (subarr.size() % 2 != 0) {
            System.out.println(subarr);
            sum = sum + getSum(subarr, arr);
        }
        for (int i = idx; i < arr.length; i++) {
            if (subarr.size() == 0 || subarr.get(subarr.size() - 1) + 1 == i) {
                subarr.add(i);
                sum = getOddSubarraySumHelper(arr, i + 1, sum, subarr);
                subarr.remove(subarr.size() - 1);
            }
        }
        return sum;
    }

    private int getSum(List<Integer> idxs, int[] arr) {
        int sum = 0;
        for (int i = 0; i < idxs.size(); i++) {
            int idx = idxs.get(i);
            sum += arr[idx];
        }
        return sum;
    }

    public static void main(String[] args) {
        SumOfAllOddLengthSubarrays obj = new SumOfAllOddLengthSubarrays();
        int[] arr = { 1, 4, 2, 5, 3 };
        System.out.println(obj.sumOddLengthSubarrays(arr));
    }
}
