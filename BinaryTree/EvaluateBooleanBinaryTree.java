package BinaryTree;

public class EvaluateBooleanBinaryTree {

    public boolean evaluateTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        return evalTreeDfsHelper(root);
    }

    private boolean evalTreeDfsHelper(TreeNode root) {
        if (root.left == null || root.right == null) {
            // means leaft node,converting to boolean and return
            return root.val == 1;
        }
        // now calculate for both left and right
        boolean leftVal = evalTreeDfsHelper(root.left);
        boolean rightVal = evalTreeDfsHelper(root.right);
        // Now calculating the result
        if (root.val == 2) {
            return leftVal || rightVal;
        } else if (root.val == 3) {
            return leftVal && rightVal;
        }
        // default return false
        return false;
    }

    public static void main(String[] args) {
        EvaluateBooleanBinaryTree obj = new EvaluateBooleanBinaryTree();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(obj.evaluateTree(root));
    }
}
