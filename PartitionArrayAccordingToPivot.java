import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionArrayAccordingToPivot {

    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> lesser = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        int pivotCount = 0;
        // Lets just iterate and push
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                lesser.add(nums[i]);
            } else if (nums[i] > pivot) {
                greater.add(nums[i]);
            } else {
                pivotCount += 1;
            }
        }
        System.out.println(lesser);
        System.out.println(greater);
        // And now add back to nums
        // add lesser
        for (int i = 0; i < lesser.size(); i++) {
            nums[i] = lesser.get(i);
        }
        // Add the pivot now
        for (int i = 0; i < pivotCount; i++) {
            nums[i + lesser.size()] = pivot;
        }
        // finally add greater
        for (int i = 0; i < greater.size(); i++) {
            nums[i + lesser.size() + pivotCount] = greater.get(i);
        }
        return nums;
    }

    public static void main(String[] args) {
        PartitionArrayAccordingToPivot obj = new PartitionArrayAccordingToPivot();
        int[] nums = { 9, 12, 5, 10, 14, 3, 10 };
        int[] ans = obj.pivotArray(nums, 10);
        System.out.println(Arrays.toString(ans));
    }
}