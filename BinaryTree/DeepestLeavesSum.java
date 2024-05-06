package BinaryTree;

public class DeepestLeavesSum {

    public int deepestLeavesSum(TreeNode root) {
        return deepestLeavesSumHelper(root, findDepth(root), 0, 0);
    }

    private int findDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(findDepth(root.left), findDepth(root.right)) + 1;
    }

    private int deepestLeavesSumHelper(TreeNode root, int maxDepth, int currDepth, int deepestLeavesSum) {
        if (root == null) {
            return deepestLeavesSum;
        }
        currDepth += 1;
        if (currDepth == maxDepth && root.left == null && root.right == null) {
            deepestLeavesSum += root.val;
        }
        deepestLeavesSum = deepestLeavesSumHelper(root.left, maxDepth, currDepth, deepestLeavesSum);
        deepestLeavesSum = deepestLeavesSumHelper(root.right, maxDepth, currDepth, deepestLeavesSum);
        return deepestLeavesSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        DeepestLeavesSum obj = new DeepestLeavesSum();
        int ans = obj.deepestLeavesSum(root);
        System.out.println(ans);
    }
}
