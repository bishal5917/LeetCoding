
public class CountCompleteTreeNodes {

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

    public int countNodes(TreeNode root) {
        if (root==null){
            return 0;
        }
         return countHelper(root.left);
    }

    private int countHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1+countHelper(root.left)+countHelper(root.right);
    }

    public static void main(String[] args) {

    }
}
