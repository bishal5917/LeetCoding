package BinaryTreePathfinding;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    TreeNode cameFrom;
    String direction;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right, TreeNode parent, TreeNode cameFrom, String direction) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.cameFrom = cameFrom;
        this.direction = direction;
    }
}

public class StepByStepDirectionsFromABinaryTreeNodeToAnother {

    public String getDirections(TreeNode root, int startValue, int destValue) {
        setParentForAllNodes(root);
        TreeNode finalNode = performBFSPathfindingAndTrackDirections(root, startValue, destValue);
        return traceAndReturnPath(finalNode, startValue, destValue);
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

    private TreeNode performBFSPathfindingAndTrackDirections(TreeNode root, int startValue, int destValue) {
        TreeNode startNode = getNode(root, startValue);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        TreeNode finalNode = new TreeNode();
        if (startNode == null) {
            return finalNode;
        }
        queue.offer(startNode);
        visited.add(startNode.val);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == destValue) {
                finalNode = node;
                return node;
            }
            if (node.parent != null && !visited.contains(node.parent.val)) {
                node.parent.cameFrom = node;
                node.parent.direction = "U";
                queue.offer(node.parent);
                visited.add(node.parent.val);
            }
            if (node.left != null && !visited.contains(node.left.val)) {
                node.left.cameFrom = node;
                node.left.direction = "L";
                queue.offer(node.left);
                visited.add(node.left.val);
            }
            if (node.right != null && !visited.contains(node.right.val)) {
                node.right.cameFrom = node;
                node.right.direction = "R";
                queue.offer(node.right);
                visited.add(node.right.val);
            }
        }
        return finalNode;
    }

    private String traceAndReturnPath(TreeNode endNode, int startValue, int destValue) {
        String path = "";
        while (endNode != null) {
            path += endNode.direction;
            endNode = endNode.cameFrom;
            if (endNode != null && endNode.val == startValue) {
                break;
            }
        }
        String reversedPath = new StringBuilder(path).reverse().toString();
        return reversedPath;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);
        StepByStepDirectionsFromABinaryTreeNodeToAnother obj = new StepByStepDirectionsFromABinaryTreeNodeToAnother();
        String ans = obj.getDirections(root, 3, 6);
        System.out.println(ans);
    }
}
