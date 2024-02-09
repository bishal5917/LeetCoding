import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NonDecreasingSubsequence {

    public List<List<Integer>> findSubsequences(int[] nums) {
        return findAllNonDecreasingSubsequence(nums, new ArrayList<>(), new HashSet<>(), new ArrayList<>(), 0);
    }

    private List<List<Integer>> findAllNonDecreasingSubsequence(int[] nums, List<List<Integer>> allSeqs,
            Set<List<Integer>> usedSeqs,
            List<Integer> currSeq, int start) {
        if (currSeq.size() >= 2 && !usedSeqs.contains(currSeq)) {
            allSeqs.add(new ArrayList<>(currSeq));
            usedSeqs.add(new ArrayList<>(currSeq));
        }
        for (int i = start; i < nums.length; i++) {
            if (currSeq.isEmpty()) {
                currSeq.add(nums[i]);
                findAllNonDecreasingSubsequence(nums, allSeqs, usedSeqs, currSeq, i + 1);
                currSeq.remove(currSeq.size() - 1);
            } else {
                if (currSeq.get(currSeq.size() - 1) <= nums[i]) {
                    currSeq.add(nums[i]);
                    findAllNonDecreasingSubsequence(nums, allSeqs, usedSeqs, currSeq, i + 1);
                    currSeq.remove(currSeq.size() - 1);
                }
            }
        }
        return allSeqs;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 6, 7, 7 };
        NonDecreasingSubsequence obj = new NonDecreasingSubsequence();
        List<List<Integer>> ans = obj.findSubsequences(nums);
        System.out.println(ans);
    }
}