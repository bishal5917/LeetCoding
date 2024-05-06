package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return -1;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                root = queue.poll();
                if (root.right != null) {
                    queue.offer(root.right);
                }
                if (root.left != null) {
                    queue.offer(root.left);
                }
            }
        }
        return root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        BottomLeftTreeValue obj = new BottomLeftTreeValue();
        int sum = obj.findBottomLeftValue(root);
        System.out.println(sum);
    }
}
