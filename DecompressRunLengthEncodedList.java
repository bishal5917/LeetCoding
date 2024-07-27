import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecompressRunLengthEncodedList {

    public int[] decompressRLElist(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            int num = nums[i + 1];
            int freq = nums[i];
            for (int qty = 0; qty < freq; qty++) {
                ans.add(num);
            }
        }
        int[] decompressed = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            decompressed[i] = ans.get(i);
        }
        return decompressed;
    }

    public static void main(String[] args) {
        DecompressRunLengthEncodedList obj = new DecompressRunLengthEncodedList();
        int[] nums = { 1, 2, 3, 4 };
        int[] ans = obj.decompressRLElist(nums);
        System.out.println(Arrays.toString(ans));
    }
}
