import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MostFrequentSubtreeSum {

    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> frequentSums = new ArrayList<>();
        if (root == null) {
            return frequentSums.stream().mapToInt(Integer::intValue).toArray();
        }
        findSums(root);
        int currMaxMode = Integer.MIN_VALUE;
        HashMap<Integer, Integer> counts = findModeHelper(root, new HashMap<>());
        for (int key : counts.keySet()) {
            int val = counts.get(key);
            currMaxMode = Math.max(val, currMaxMode);
        }
        for (int key : counts.keySet()) {
            if (counts.get(key) == currMaxMode) {
                frequentSums.add(key);
            }
        }
        System.out.println(frequentSums);
        return frequentSums.stream().mapToInt(Integer::intValue).toArray();
    }

    private HashMap<Integer, Integer> findModeHelper(TreeNode root, HashMap<Integer, Integer> countMap) {
        if (root == null) {
            return countMap;
        }
        if (countMap.get(root.val) == null) {
            countMap.put(root.val, 0);
        }
        if (countMap.get(root.val) != null) {
            int prevCount = countMap.get(root.val);
            countMap.put(root.val, prevCount + 1);
        }
        countMap = findModeHelper(root.left, countMap);
        countMap = findModeHelper(root.right, countMap);
        return countMap;
    }

    private void findSums(TreeNode node) {
        if (node == null) {
            return;
        }
        int summedVal = findAllSubtreeAndSumUp(node, 0);
        node.val = summedVal;
        findSums(node.left);
        ;
        findSums(node.right);
    }

    private int findAllSubtreeAndSumUp(TreeNode node, int sum) {
        if (node == null) {
            return sum;
        }
        sum = sum + node.val;
        sum = findAllSubtreeAndSumUp(node.left, sum);
        sum = findAllSubtreeAndSumUp(node.right, sum);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        MostFrequentSubtreeSum obj = new MostFrequentSubtreeSum();
        obj.findFrequentTreeSum(root);
    }
}
