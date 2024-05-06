package BinaryTree;

public class SearchBst {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        return searchBSTHelper(root, val);
    }

    private TreeNode searchBSTHelper(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        if (root != null && root.val == val) {
            return root;
        }
        if (val < root.val) {
            return searchBSTHelper(root.left, val);
        }
        return searchBSTHelper(root.right, val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        SearchBst obj = new SearchBst();
        System.out.println(obj.searchBST(root, 2).val);
    }

}
