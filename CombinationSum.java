import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        performRecursion(0, 0, new ArrayList<>(), res, candidates, target);
        return res;
    }

    public void performRecursion(int i, int total, List<Integer> currArray, List<List<Integer>> res, int[] candidates,
            int target) {
        if (target == total) {
            res.add(new ArrayList<>(currArray));
            return;
        }
        if (i >= candidates.length || total > target) {
            return;
        }
        currArray.add(candidates[i]);
        performRecursion(i, total + candidates[i], currArray, res, candidates, target);
        currArray.remove(currArray.size() - 1);
        performRecursion(i + 1, total, currArray, res, candidates, target);
    }

    public static void main(String[] args) {
        int[] result = { 2, 3, 6, 7 };
        int target = 7;
        CombinationSum obj = new CombinationSum();
        obj.combinationSum(result, target);
    }
}