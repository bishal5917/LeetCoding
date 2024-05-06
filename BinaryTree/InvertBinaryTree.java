package BinaryTree;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        return inversionHelper(root);
    }

    private TreeNode inversionHelper(TreeNode root) {
        if (root == null) {
            return root;
        }
        // swap nodes for the root
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // do this recursively for both left subtree and the right subtree
        inversionHelper(root.left);
        inversionHelper(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        InvertBinaryTree obj = new InvertBinaryTree();
        System.out.println(obj.invertTree(root));
    }
}
