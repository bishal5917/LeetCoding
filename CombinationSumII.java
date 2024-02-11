import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return findAllCombinations(candidates, target, new ArrayList<>(), new ArrayList<>(), 0, 0);
    }

    private List<List<Integer>> findAllCombinations(int[] candidates, int target, List<List<Integer>> combs,
            List<Integer> currComb, int currSum, int index) {
        if (currSum == target) {
            combs.add(new ArrayList<>(currComb));
            return combs;
        }

        for (int i = index; i < candidates.length; i++) {
            // Skip duplicates to avoid duplicate combinations
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            currSum = currSum + candidates[i];

            if (currSum <= target) {
                currComb.add(candidates[i]);
                combs = findAllCombinations(candidates, target, combs, currComb, currSum, i + 1);
                currComb.remove(currComb.size() - 1);
                currSum = currSum - candidates[i];
            } else {
                break;
            }
        }
        return combs;
    }

    public static void main(String[] args) {
        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        CombinationSumII obj = new CombinationSumII();
        List<List<Integer>> ans = obj.combinationSum2(candidates, target);
        System.out.println(ans);
    }
}
