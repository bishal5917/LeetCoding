package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfBinaryTree {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean wasOnlyLeftEncountered = false;

        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.left != null) {
                queue.offer(root.left);
                if (wasOnlyLeftEncountered == true) {
                    return false;
                }
            } else {
                wasOnlyLeftEncountered = true;
            }
            if (root.right != null) {
                queue.offer(root.right);
                if (wasOnlyLeftEncountered == true) {
                    return false;
                }
            } else {
                wasOnlyLeftEncountered = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);
        CheckCompletenessOfBinaryTree obj = new CheckCompletenessOfBinaryTree();
        Object ans = obj.isCompleteTree(root);
        System.out.println(ans);
    }
}
