import java.util.ArrayList;
import java.util.List;

public class StringConcatenationEqualsTarget {

    public int numOfPairs(String[] nums, String target) {
        return countAfterConcatenationHelper(nums, new ArrayList<>(), target, 0, 0);
    }

    private int countAfterConcatenationHelper(String[] nums, List<Integer> pair, String target, int count, int idx) {
        if (pair.size() == 2) {
            // Now check if we can meet the target
            StringBuilder curr = new StringBuilder();
            curr.append(nums[pair.get(0)]);
            curr.append(nums[pair.get(1)]);
            if (target.equals(curr.toString())) {
                count += 1;
            }
            return count;
        }
        // just check every pair possible except equal pairs
        for (int i = 0; i < nums.length; i++) {
            if ((pair.size() != 0 && pair.get(0) != i) || pair.size() == 0) {
                pair.add(i);
                count = countAfterConcatenationHelper(nums, pair, target, count, idx + 1);
                pair.remove(pair.size() - 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] nums = { "777", "7", "77", "77" };
        String target = "7777";
        StringConcatenationEqualsTarget obj = new StringConcatenationEqualsTarget();
        System.out.println(obj.numOfPairs(nums, target));
    }

}
