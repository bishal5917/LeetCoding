import java.util.Arrays;

public class MaxElemAfterDecreasingAndRearranging {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int prev = 0;
        for (int i = 0; i < n; i++) {
            prev = Math.min(prev + 1, arr[i]);
        }
        return prev;
    }

    public static void main(String[] args) {
        MaxElemAfterDecreasingAndRearranging obj = new MaxElemAfterDecreasingAndRearranging();
        int[] arr = { 2, 2, 1, 2, 1 };
        System.out.println(obj.maximumElementAfterDecrementingAndRearranging(arr));
    }
}
