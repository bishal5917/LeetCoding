package Recursions;

public class CheckStrictlyIncreasingArray {

    private boolean isArrayStrictlyIncreasing(int[] arr) {
        return checkIsArraySTrictlyIncreasingHelper(arr, 0);
    }

    private boolean checkIsArraySTrictlyIncreasingHelper(int[] arr, int index) {
        if (index >= arr.length - 1) {
            return true;
        }
        if (arr[index + 1] > arr[index]) {
            return checkIsArraySTrictlyIncreasingHelper(arr, index + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        CheckStrictlyIncreasingArray obj = new CheckStrictlyIncreasingArray();
        boolean ans = obj.isArrayStrictlyIncreasing(arr);
        System.out.println(ans);
    }
}
