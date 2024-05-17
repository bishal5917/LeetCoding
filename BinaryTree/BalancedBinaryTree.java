package BinaryTree;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int val = heightHelper(root);
        return val == -1 ? false : true;
    }

    private int heightHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightHelper(root.left);
        int rightHeight = heightHelper(root.right);
        if (leftHeight == -1 || rightHeight == -1)
            return -1;
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        BalancedBinaryTree obj = new BalancedBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(obj.isBalanced(root));
    }
}
