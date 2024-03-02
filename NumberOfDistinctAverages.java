import java.util.Arrays;
import java.util.HashSet;

public class NumberOfDistinctAverages {

    public int distinctAverages(int[] nums) {
        HashSet<Double> averages = new HashSet<>();
        int i = 0;
        int j = nums.length - 1;
        Arrays.sort(nums);
        while (i < j) {
            int smallest = nums[i];
            int largest = nums[j];
            double average = (smallest + largest + 0.0) / 2;
            averages.add(average);
            i += 1;
            j -= 1;
        }
        System.out.println(averages);
        return averages.size();
    }

    public static void main(String[] args) {
        NumberOfDistinctAverages obj = new NumberOfDistinctAverages();
        int[] nums = { 9, 5, 7, 8, 7, 9, 8, 2, 0, 7 };
        System.out.println(obj.distinctAverages(nums));
    }
}
