import java.util.ArrayList;
import java.util.List;

public class NumberOfArithmeticTriplets {

    public int arithmeticTriplets(int[] nums, int diff) {
        return countArithemeticTripletHelper(nums, diff, new ArrayList<>(), 0, 0);
    }

    private int countArithemeticTripletHelper(int[] nums, int diff, List<Integer> currTriplet, int count, int idx) {
        if (currTriplet.size() == 3) {
            // Now check if that triplet is arithmetic or not
            if (isArithmeticTriplet(nums, currTriplet, diff)) {
                count = count + 1;
            }
            return count;
        }
        for (int i = idx; i < nums.length; i++) {
            if (currTriplet.size() == 0 || (currTriplet.size() != 0 && currTriplet.get(currTriplet.size() - 1) < i)) {
                currTriplet.add(i);
                count = countArithemeticTripletHelper(nums, diff, currTriplet, count, idx + 1);
                currTriplet.remove(currTriplet.size() - 1);
            }
        }
        return count;
    }

    private boolean isArithmeticTriplet(int[] nums, List<Integer> idxs, int diff) {
        int a = idxs.get(0);
        int b = idxs.get(1);
        int c = idxs.get(2);
        int diffA = Math.abs(nums[b] - nums[a]);
        int diffB = Math.abs(nums[c] - nums[b]);
        return diffA == diff && diffB == diff;
    }

    public static void main(String[] args) {
        NumberOfArithmeticTriplets obj = new NumberOfArithmeticTriplets();
        int[] nums = { 0, 1, 4, 6, 7, 10 };
        int diff = 3;
        System.out.println(obj.arithmeticTriplets(nums, diff));
    }

}
