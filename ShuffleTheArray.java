import java.util.Arrays;

public class ShuffleTheArray {

    public int[] shuffle(int[] nums, int n) {
        int[] shuffled = new int[nums.length];
        // Lets use the two pointers technique
        int i = 0;
        int j = n;
        int idx = 0;
        while (j < nums.length) {
            shuffled[idx++] = nums[i];
            shuffled[idx++] = nums[j];
            i += 1;
            j += 1;
        }
        return shuffled;
    }

    public static void main(String[] args) {
        ShuffleTheArray obj = new ShuffleTheArray();
        int[] nums = { 2, 5, 1, 3, 4, 7 };
        int n = 3;
        int[] ans = obj.shuffle(nums, n);
        System.out.println(Arrays.toString(ans));
    }
}