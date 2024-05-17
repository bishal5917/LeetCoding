package BinaryTree;

public class BinaryTreeDiameter {

    int diameter = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        getDiameterHelper(root);
        return diameter;
    }

    private int getDiameterHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getDiameterHelper(root.left);
        int rightHeight = getDiameterHelper(root.right);
        diameter = Math.max(leftHeight + rightHeight, diameter);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        BinaryTreeDiameter obj = new BinaryTreeDiameter();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(obj.diameterOfBinaryTree(root));
    }
}
