package Sorting;

import java.util.Arrays;

public class MergeSort {

    public int[] sortArray(int[] nums) {
        divide(nums, 0, nums.length - 1);
        return nums;
    }

    private void divide(int[] nums, int start, int end) {
        if (end - start + 1 <= 1) {
            return;
        }
        int mid = start + (end - start) / 2;
        divide(nums, start, mid);
        divide(nums, mid + 1, end);
        // Merge or Conquer
        merge(nums, start, mid, end);

    }

    private void merge(int[] nums, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = 0;
        int[] sorted = new int[end - start + 1];
        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                sorted[k] = nums[i];
                i += 1;
            } else {
                sorted[k] = nums[j];
                j += 1;
            }
            k += 1;
        }
        while (i <= mid) {
            sorted[k] = nums[i];
            i += 1;
            k += 1;
        }
        while (j <= end) {
            sorted[k] = nums[j];
            j += 1;
            k += 1;
        }
        for (int idx = start; idx <= end; idx++) {
            nums[idx] = sorted[idx - start];
        }
    }

    public static void main(String[] args) {
        int[] nums = { 5, 2, 3, 1 };
        MergeSort obj = new MergeSort();
        int[] ans = obj.sortArray(nums);
        System.out.println(Arrays.toString(ans));
    }

}
