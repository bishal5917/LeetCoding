package BinaryTreeInfectionTime;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right, TreeNode parent) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}

public class AmountOfTimeForBinaryTreeToBeInfected {

    public int amountOfTime(TreeNode root, int start) {
        setParentForAllNodes(root);
        TreeNode startNode = getNode(root, start);
        return findTotalInfectionTime(startNode);
    }

    private void setParentForAllNodes(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.parent = root;
        }
        if (root.right != null) {
            root.right.parent = root;
        }
        setParentForAllNodes(root.left);
        setParentForAllNodes(root.right);
    }

    private TreeNode getNode(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        TreeNode leftResult = getNode(root.left, val);
        if (leftResult != null) {
            return leftResult;
        } else {
            return getNode(root.right, val);
        }
    }

    private int findTotalInfectionTime(TreeNode startNode) {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<Integer> infected = new HashSet<>();
        int totalTime = -1;
        if (startNode == null) {
            return totalTime;
        }
        queue.offer(startNode);
        infected.add(startNode.val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.parent != null && !infected.contains(node.parent.val)) {
                    queue.offer(node.parent);
                    infected.add(node.parent.val);
                }
                if (node.left != null && !infected.contains(node.left.val)) {
                    queue.offer(node.left);
                    infected.add(node.left.val);
                }
                if (node.right != null && !infected.contains(node.right.val)) {
                    queue.offer(node.right);
                    infected.add(node.right.val);
                }
            }
            totalTime += 1;
        }
        return totalTime;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(6);
        AmountOfTimeForBinaryTreeToBeInfected obj = new AmountOfTimeForBinaryTreeToBeInfected();
        int ans = obj.amountOfTime(root, 3);
        System.out.println(ans);
    }
}
