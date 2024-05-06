package BinaryTree;

public class DeleteLeavesWithAGivenValue {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return removeLeavesHelper(root, target);
    }

    private TreeNode removeLeavesHelper(TreeNode root, int target) {
        if (root == null) {
            return root;
        }
        root.left = removeLeavesHelper(root.left, target);
        root.right = removeLeavesHelper(root.right, target);
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(2);
        DeleteLeavesWithAGivenValue obj = new DeleteLeavesWithAGivenValue();
        obj.removeLeafNodes(root, 2);
    }
}
