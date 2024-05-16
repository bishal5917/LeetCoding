package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CousinsInBinaryTreeII {

    public TreeNode replaceValueInTree(TreeNode root) {
        List<Integer> levelSums = bfsHelperFindLevelSums(root);
        bfsHelperPopulateCousins(root, levelSums);
        System.out.println(levelSums);
        // root have no cousins
        root.val = 0;
        return root;
    }

    private List<Integer> bfsHelperFindLevelSums(TreeNode root) {
        List<Integer> levelSums = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int currSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                currSum += curr.val;
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            levelSums.add(currSum);
        }
        return levelSums;
    }

    private void bfsHelperPopulateCousins(TreeNode root, List<Integer> levelSums) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left == null && curr.right == null) {
                    continue;
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
                int prevLeftVal = curr.left != null ? curr.left.val : 0;
                int prevRightVal = curr.right != null ? curr.right.val : 0;
                int currLevelSum = levelSums.get(level + 1);
                if (curr.left != null) {
                    curr.left.val = currLevelSum - prevLeftVal - prevRightVal;
                }
                if (curr.right != null) {
                    curr.right.val = currLevelSum - prevLeftVal - prevRightVal;
                }
            }
            level += 1;
        }
    }

    // MY INTUITION
    // FIRST TIME
    // BFS traversal to get next level sum, get the sum of each level;
    // SECOND TIME
    // During traversal, locate the nodes with 2 kids, then update the value of each
    // kid to the sum
    // of the 2kids; then for each node use level sum to minus its updated value to
    // get final value.

    public static void main(String[] args) {
        CousinsInBinaryTreeII obj = new CousinsInBinaryTreeII();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(10);
        root.right.right = new TreeNode(7);
        obj.replaceValueInTree(root);
    }
}
