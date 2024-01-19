import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

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

public class FindModeInBST {

    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<>();
        if (root == null) {
            return modes.stream().mapToInt(Integer::intValue).toArray();
        }
        int currMaxMode = Integer.MIN_VALUE;
        HashMap<Integer, Integer> counts = findModeHelper(root, new HashMap<>());
        for (int key : counts.keySet()) {
            int val = counts.get(key);
            currMaxMode = Math.max(val, currMaxMode);
        }
        for (int key : counts.keySet()) {
            if (counts.get(key)==currMaxMode){
                modes.add(key);
            }
        }
        System.out.println(modes);
        return modes.stream().mapToInt(Integer::intValue).toArray();
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        FindModeInBST obj = new FindModeInBST();
        obj.findMode(root);
    }
}
