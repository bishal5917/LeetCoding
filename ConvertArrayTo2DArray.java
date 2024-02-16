import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ConvertArrayTo2DArray {

    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> twoDArray = new ArrayList<>();
        int added = 0;
        while (added != nums.length) {
            HashSet<Integer> bucket = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    continue;
                }
                if (bucket.contains(nums[i])) {
                    continue;
                } else {
                    bucket.add(nums[i]);
                    // increment the added
                    added += 1;
                    // marking as added
                    nums[i] = 0;
                }
            }
            twoDArray.add(new ArrayList<>(bucket));
        }
        return twoDArray;
    }

    public static void main(String[] args) {
        ConvertArrayTo2DArray obj = new ConvertArrayTo2DArray();
        int[] nums = { 1, 3, 4, 1, 2, 3, 1 };
        List<List<Integer>> ans = obj.findMatrix(nums);
        System.out.println(ans);
    }

}
