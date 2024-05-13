package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EvenOddTree {

    public boolean isEvenOddTree(TreeNode root) {
        // Lets do a BFS and keep checking
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            List<Integer> levelNodes = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                levelNodes.add(curr.val);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            System.out.println(level);
            System.out.println(levelNodes);
            if (level % 2 == 0) {
                // perform even level validation
                if (validateEven(levelNodes) == false)
                    return false;
            } else {
                // perform odd level validation
                if (validateOdd(levelNodes) == false)
                    return false;
            }
            level += 1;
        }
        return true;
    }

    private boolean validateEven(List<Integer> nodes) {
        for (int i = 0; i < nodes.size() - 1; i++) {
            if (nodes.get(i) % 2 == 0) {
                return false;
            }
            if (nodes.get(i + 1) - nodes.get(i) <= 0) {
                return false;
            }
        }
        if (nodes.get(nodes.size() - 1) % 2 == 0) {
            return false;
        }
        return true;
    }

    private boolean validateOdd(List<Integer> nodes) {
        // All all be even and in strictly decreasing
        for (int i = 0; i < nodes.size() - 1; i++) {
            if (nodes.get(i) % 2 != 0) {
                return false;
            }
            if (nodes.get(i + 1) - nodes.get(i) >= 0) {
                return false;
            }
        }
        if (nodes.get(nodes.size() - 1) % 2 != 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        EvenOddTree obj = new EvenOddTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(10);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        System.out.println(obj.isEvenOddTree(root));
    }
}
