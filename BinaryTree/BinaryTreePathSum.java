package BinaryTree;

public class BinaryTreePathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return pathSumHelper(root, targetSum, 0);
    }

    public boolean pathSumHelper(TreeNode root, int targetSum, int currSum) {
        if (root == null) {
            return false;
        }
        currSum += root.val;
        if (root.left == null && root.right == null && targetSum == currSum) {
            return true;
        }
        Boolean leftOne = pathSumHelper(root.left, targetSum, currSum);
        Boolean rightOne = pathSumHelper(root.right, targetSum, currSum);
        return leftOne || rightOne;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        BinaryTreePathSum obj = new BinaryTreePathSum();
        System.out.println(obj.hasPathSum(root, 50));
    }
}
