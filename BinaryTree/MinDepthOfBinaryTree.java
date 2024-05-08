package BinaryTree;

import java.util.Arrays;

public class MinDepthOfBinaryTree {

    int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfsHelper(root, 1);
        return minDepth;
    }

    private int dfsHelper(TreeNode root, int curr) {
        if (root.left == null && root.right == null) {
            // means a leaf node,return
            minDepth = Math.min(curr, minDepth);
            return curr;
        }
        // else we go left and right
        for (TreeNode child : Arrays.asList(root.left, root.right)) {
            if (child == null) {
                continue;
            }
            curr += 1;
            curr = dfsHelper(child, curr);
            curr -= 1;
        }
        return curr;
    }

    public static void main(String[] args) {
        MinDepthOfBinaryTree obj = new MinDepthOfBinaryTree();
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        root.right.right.right.right = new TreeNode(6);
        System.out.println(obj.minDepth(root));
    }

}
