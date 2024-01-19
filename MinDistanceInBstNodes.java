
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

public class MinDistanceInBstNodes {

    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return minDiffHelper(root, Integer.MAX_VALUE);
    }

    private int minDiffHelper(TreeNode root, int currMinDiff) {
        if (root == null) {
            return currMinDiff;
        }
        if (root.left != null) {
            TreeNode maxOnLeft = findMax(root.left);
            currMinDiff = Math.min(currMinDiff, Math.abs(root.val - maxOnLeft.val));
        }
        if (root.right != null) {
            TreeNode minOnRight = findMin(root.right);
            currMinDiff = Math.min(currMinDiff, Math.abs(root.val - minOnRight.val));
        }
        currMinDiff = minDiffHelper(root.left, currMinDiff);
        currMinDiff = minDiffHelper(root.right, currMinDiff);
        return currMinDiff;
    }

    private TreeNode findMax(TreeNode node) {
        if (node.right == null) {
            return node;
        }
        return findMax(node.right);
    }

    private TreeNode findMin(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return findMin(node.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        MinDistanceInBstNodes obj = new MinDistanceInBstNodes();
        System.out.println(obj.minDiffInBST(root));
    }
}
