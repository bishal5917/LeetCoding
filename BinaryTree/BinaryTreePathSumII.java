package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return findPathsHelper(root, new ArrayList<>(), new ArrayList<>(), 0, targetSum);
    }

    public List<List<Integer>> findPathsHelper(TreeNode root, List<List<Integer>> paths, List<Integer> currPath,
            int currSum, int target) {
        if (root == null) {
            return paths;
        }
        currSum = currSum + root.val;
        currPath.add(root.val);
        if (root.left == null && root.right == null) {
            if (currSum == target) {
                paths.add(new ArrayList<>(currPath));
            }
            // Remove the last element - Backtrack
            // Decrement the current element from root - Backtrack
            currPath.remove(currPath.size() - 1);
            currSum = currSum - root.val;
            return paths;
        }
        paths = findPathsHelper(root.left, paths, new ArrayList<>(currPath), currSum, target);
        paths = findPathsHelper(root.right, paths, new ArrayList<>(currPath), currSum, target);
        return paths;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        BinaryTreePathSumII obj = new BinaryTreePathSumII();
        List<List<Integer>> paths = obj.pathSum(root, 4);
        System.out.println(paths);
    }
}
