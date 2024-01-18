
class TreeNode {
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

public class UnivaluedBinaryTree {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        return univaluedTreeHelper(root.left, root.val) && univaluedTreeHelper(root.right, root.val);
    }

    private Boolean univaluedTreeHelper(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        if (root.val != val) {
            return false;
        }
        Boolean val1 = univaluedTreeHelper(root.left, val);
        Boolean val2 = univaluedTreeHelper(root.right, val);
        return val1 && val2;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(2);
        UnivaluedBinaryTree obj = new UnivaluedBinaryTree();
        System.out.println(obj.isUnivalTree(root));
    }

}