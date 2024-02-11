import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        return combinationSumsHelper(k, n, new ArrayList<>(), new ArrayList<>(), 0, 1);
    }

    private List<List<Integer>> combinationSumsHelper(int maxLen, int target, List<List<Integer>> sums,
            List<Integer> curr, int currSum, int index) {
        if (curr.size() == maxLen) {
            if (currSum == target) {
                sums.add(new ArrayList<>(curr));
            }
            return sums;
        }
        for (int i = index; i <= 9; i++) {
            if (curr.isEmpty() || (!curr.isEmpty() && !curr.contains(i) && curr.get(curr.size() - 1) < i)) {
                currSum += i;
                curr.add(i);
                combinationSumsHelper(maxLen, target, sums, curr, currSum, index + 1);
                currSum -= i;
                curr.remove(curr.size() - 1);
            }
        }
        return sums;
    }

    public static void main(String[] args) {
        CombinationSumIII obj = new CombinationSumIII();
        int k = 3;
        int n = 9;
        List<List<Integer>> ans = obj.combinationSum3(k, n);
        System.out.println(ans);
    }

}
