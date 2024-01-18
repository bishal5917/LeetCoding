
public class SumOfLeftLeaves {

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

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSubtreeLeaf = leafSumHelper(0, root.left, true);
        int rightSubtreeLeaf = leafSumHelper(0, root.right, false);
        return leftSubtreeLeaf + rightSubtreeLeaf;
    }

    public int leafSumHelper(int currSum, TreeNode root, Boolean isLeft) {
        if (root == null) {
            return currSum;
        }
        if (root.left == null && root.right == null && isLeft == true) {
            currSum = currSum + root.val;
        }
        currSum = leafSumHelper(currSum, root.left, true);
        currSum = leafSumHelper(currSum, root.right, false);
        return currSum;
    }

    public static void main(String[] args) {

    }
}
