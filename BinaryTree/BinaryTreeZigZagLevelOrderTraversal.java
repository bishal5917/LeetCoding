package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigZagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> traversals = new ArrayList<>();
        if (root == null) {
            return traversals;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftFirst = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode polled = queue.poll();
                currLevel.add(polled.val);
                if (polled.left != null) {
                    queue.add(polled.left);
                }
                if (polled.right != null) {
                    queue.add(polled.right);
                }
            }
            if (leftFirst == false) {
                Collections.reverse(currLevel);
            }
            traversals.add(currLevel);
            leftFirst = !leftFirst;
        }

        return traversals;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        BinaryTreeZigZagLevelOrderTraversal obj = new BinaryTreeZigZagLevelOrderTraversal();
        System.out.println(obj.zigzagLevelOrder(root));
    }
}
