package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AddOneRowToTree {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // Handle case for depth=1
        if (depth == 1) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }
        // Lets just find all the nodes at the level(depth-1) first using BFS
        List<TreeNode> nodes = bfsHelper(root, depth);
        System.out.println(nodes);
        for (TreeNode node : nodes) {
            // Now time to insert the nodes
            if (node.left != null) {
                TreeNode newNode = new TreeNode(val);
                TreeNode prevNode = node.left;
                node.left = null;
                node.left = newNode;
                newNode.left = prevNode;
            } else {
                node.left = new TreeNode(val);
            }
            if (node.right != null) {
                TreeNode newNode = new TreeNode(val);
                TreeNode prevNode = node.right;
                node.right = null;
                node.right = newNode;
                newNode.right = prevNode;
            } else {
                node.right = new TreeNode(val);
            }
        }
        return root;
    }

    private List<TreeNode> bfsHelper(TreeNode root, int depth) {
        // Lets do a BFS and keep checking
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            if (level == depth - 1) {
                return new ArrayList<>(queue);
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            level += 1;
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        AddOneRowToTree obj = new AddOneRowToTree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);
        obj.addOneRow(root, 1, 2);
    }
}
