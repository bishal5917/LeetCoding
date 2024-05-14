package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    TreeNode id;
    int val;

    public Pair(TreeNode id, int val) {
        this.id = id;
        this.val = val;
    }
}

public class MaximumWidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        return bfsHelper(root);
    }

    private int bfsHelper(TreeNode root) {
        // Lets do a BFS and keep checking
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            Pair left = queue.peek();
            Pair right = left;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                right = queue.poll();
                if (right.id.left != null) {
                    queue.offer(new Pair(right.id.left, 2 * right.val));
                }
                if (right.id.right != null) {
                    queue.offer(new Pair(right.id.right, 2 * right.val + 1));
                }
            }
            maxWidth = Math.max(maxWidth, right.val - left.val + 1);
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        MaximumWidthOfBinaryTree obj = new MaximumWidthOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        System.out.println(obj.widthOfBinaryTree(root));
    }
}
