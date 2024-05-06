package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {

    // what we gotta do is perform level order traversal on a tree (BFS traversal)
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();
        if (root == null) {
            return averages;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            double average = 0;
            for (int i = 0; i < size; i++) {
                TreeNode polled = queue.poll();
                sum += polled.val;
                if (polled.left != null) {
                    queue.add(polled.left);
                }
                if (polled.right != null) {
                    queue.add(polled.right);
                }
            }
            average = sum / size;
            averages.add(average);
        }

        return averages;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        AverageOfLevelsInBinaryTree obj = new AverageOfLevelsInBinaryTree();
        System.out.println(obj.averageOfLevels(root));
    }
}
