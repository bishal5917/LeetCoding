package Sorting;

import java.util.Arrays;

public class CycleSort {

    public void cycleSort(int[] nums) {
        int swaps = 0;
        // Go for every index of the nums and perform
        for (int i = 0; i < nums.length; i++) {
            while (getTotalSmallerToRight(nums, i) != 0) {
                swaps += 1;
                int idx = getTotalSmallerToRight(nums, i);
                int nextIdx = i + idx;
                // Then swap elements at i and nextIdx
                int temp = nums[i];
                nums[i] = nums[nextIdx];
                nums[nextIdx] = temp;
            }
        }
        System.out.println(swaps);
    }

    private int getTotalSmallerToRight(int[] nums, int idx) {
        int count = 0;
        int curr = nums[idx];
        for (int i = idx + 1; i < nums.length; i++) {
            if (nums[i] < curr) {
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CycleSort obj = new CycleSort();
        int[] nums = { 7, 6, 8, 5 };
        System.out.println(Arrays.toString(nums));
        obj.cycleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
