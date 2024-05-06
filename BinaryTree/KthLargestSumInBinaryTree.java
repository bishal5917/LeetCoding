package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KthLargestSumInBinaryTree {

    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> sums = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return -1;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Long currentLevelSum = 0L;
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                currentLevelSum += root.val;
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            sums.add(currentLevelSum);
        }
        if (k > sums.size()) {
            return -1;
        }
        Collections.sort(sums, Collections.reverseOrder());
        return sums.get(k - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(6);
        KthLargestSumInBinaryTree obj = new KthLargestSumInBinaryTree();
        System.out.println(obj.kthLargestLevelSum(root, 2));
    }
}