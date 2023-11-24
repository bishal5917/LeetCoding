// package ShellSort;

import java.util.Arrays;

public class ShellSort {
    public void sort(int[] nums) {
        int gap = Math.floorDiv(nums.length, 2);
        int i = 0;
        int j = gap;
        while (gap != 0) {
            while (j <= nums.length - 1) {
                if (nums[i] > nums[j]) {
                    // swap and check previous if any
                    swap(i, j, nums);
                    if (i - gap >= 0 && nums[i - gap] > nums[i]) {
                        swap(i - gap, i, nums);
                    }
                }
                i += 1;
                j += 1;
            }
            gap -= 1;
            j = gap;
            i = 0;
        }
    }

    private void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 23, 29, 15, 19, 31, 7, 9, 5, 2 };
        ShellSort obj = new ShellSort();
        System.out.println(Arrays.toString(nums));
        obj.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
