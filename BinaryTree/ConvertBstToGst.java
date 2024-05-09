package BinaryTree;

public class ConvertBstToGst {

    public TreeNode bstToGst(TreeNode root) {
        TreeNode curr = root;
        reversedInOrder(curr, 0);
        return root;
    }

    // Gotta do this using reversed inOrder Traversal
    private int reversedInOrder(TreeNode root, int currSum) {
        if (root == null) {
            return currSum;
        }
        currSum = reversedInOrder(root.right, currSum);
        root.val = root.val + currSum;
        currSum = root.val;
        System.out.println(root.val);
        currSum = reversedInOrder(root.left, currSum);
        return currSum;
    }

    public static void main(String[] args) {
        ConvertBstToGst obj = new ConvertBstToGst();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        obj.bstToGst(root);
    }
}
