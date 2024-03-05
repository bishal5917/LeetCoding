import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    private static int LAST = 10001;

    // This is for remove duplicates II question (MEDIUM)
    public int removeDuplicatesII(int[] nums) {
        int count = 0;
        // USING SLOW AND FAST POINTERS
        if (nums.length < 2) {
            return nums.length;
        }
        int s = 0;
        int f = 1;
        // If found duplicates gotta remove,lets do it
        while (s < nums.length && f < nums.length) {
            if (nums[f] == LAST) {
                // means no need to replace,just return
                break;
            }
            if (f + 1 < nums.length && nums[s] == nums[f] && nums[s] == nums[f + 1]) {
                // means more than duplicates found
                // now shift from f+1 to the last and add - at last
                shift(nums, f + 1);
                // count how many we removed
                count += 1;
            } else {
                f += 1;
                s += 1;
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums.length - count;
    }

    // This is for remove duplicates I question (EASY)
    public int removeDuplicates(int[] nums) {
        int count = 0;
        // lets use two pointers
        if (nums.length < 2) {
            return nums.length;
        }
        int s = 0;
        int f = 1;
        // If found duplicates gotta remove,lets do it
        while (s < nums.length && f < nums.length) {
            if (nums[f] == LAST) {
                // means no need to replace,just return
                break;
            }
            if (nums[s] == nums[f]) {
                // means more than duplicates found
                // now shift from f+1 to the last and add - at last
                shift(nums, f);
                // count how many we removed
                count += 1;
            } else {
                f += 1;
                s += 1;
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums.length - count;
    }

    private void shift(int[] nums, int st) {
        while (st + 1 < nums.length) {
            if (nums[st + 1] == LAST) {
                // means this was a blank space already
                break;
            }
            nums[st] = nums[st + 1];
            st += 1;
        }
        // add 10001 to the last
        nums[st] = LAST;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();
        int[] nums = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
        System.out.println(obj.removeDuplicatesII(nums));
        System.out.println(obj.removeDuplicates(nums));
    }
}
