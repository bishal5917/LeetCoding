import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversals {
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

    public List<Integer> binaryTreeTraversal(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        return inOrderHelper(root,vals);
        // return preOrderHelper(root, vals);
        // return postOrderHelper(root, vals);
    }

    private List<Integer> inOrderHelper(TreeNode root,List<Integer>vals) {
        if (root == null) {
            return vals;
        }
        inOrderHelper(root.left,vals);
        vals.add(root.val);
        inOrderHelper(root.right, vals);
        return vals;
    }

    private List<Integer> preOrderHelper(TreeNode root, List<Integer> vals) {
        if (root == null) {
            return vals;
        }
        vals.add(root.val);
        preOrderHelper(root.left, vals);
        preOrderHelper(root.right, vals);
        return vals;
    }

    private List<Integer> postOrderHelper(TreeNode root, List<Integer> vals) {
        if (root == null) {
            return vals;
        }
        postOrderHelper(root.left, vals);
        postOrderHelper(root.right, vals);
        vals.add(root.val);
        return vals;
    }

    public static void main(String[] args) {

    }
}
