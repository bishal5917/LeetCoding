
class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        int leftDepth = leftDepthHelper(0, root);
        int rightDepth = rightDepthHelper(0, root);
        return Math.max(leftDepth, rightDepth);
    }

    private int leftDepthHelper(int currDepth, TreeNode root) {
        if (root == null) {
            return currDepth;
        }
        return Math.max(leftDepthHelper(currDepth + 1, root.left), leftDepthHelper(currDepth + 1, root.right));
    }

    private int rightDepthHelper(int currDepth, TreeNode root) {
        if (root == null) {
            return currDepth;
        }
        return Math.max(rightDepthHelper(currDepth + 1, root.left), rightDepthHelper(currDepth + 1, root.right));
    }

    public static void main(String[] args) {

    }
}