package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseOddLevelsOfBinaryTree {

    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) {
            return root;
        }
        bfsHelper(root);
        return root;
    }

    private void bfsHelper(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> levelNodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                levelNodes.add(curr);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            System.out.println(levelNodes);
            if (level % 2 != 0) {
                reverseLevel(levelNodes);
            }
            level += 1;
        }
    }

    private void reverseLevel(List<TreeNode> nodes) {
        int l = 0;
        int r = nodes.size() - 1;
        while (l < r) {
            TreeNode left = nodes.get(l);
            TreeNode right = nodes.get(r);
            // Swap the values
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
            l += 1;
            r -= 1;
        }
    }

    public static void main(String[] args) {
        ReverseOddLevelsOfBinaryTree obj = new ReverseOddLevelsOfBinaryTree();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(13);
        root.right.left = new TreeNode(21);
        root.right.right = new TreeNode(34);
        obj.reverseOddLevels(root);
    }
}
