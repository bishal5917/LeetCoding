
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

public class MaximumDifferenceBetweenNodeAndAncestor {

    public int maxAncestorDiff(TreeNode root) {
        return findMaxAncestorHelper(root, root.val, root.val);
    }

    private int findMaxAncestorHelper(TreeNode root, int maxAncestor, int minAncestor) {
        if (root == null) {
            return maxAncestor - minAncestor;
        }
        maxAncestor = Math.max(maxAncestor, root.val);
        minAncestor = Math.min(minAncestor, root.val);
        int leftMaxDiff = findMaxAncestorHelper(root.left, maxAncestor, minAncestor);
        int rightMaxDiff = findMaxAncestorHelper(root.right, maxAncestor, minAncestor);
        return Math.max(leftMaxDiff, rightMaxDiff);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(0);
        root.right.right.left = new TreeNode(3);
        MaximumDifferenceBetweenNodeAndAncestor obj = new MaximumDifferenceBetweenNodeAndAncestor();
        int ans = obj.maxAncestorDiff(root);
        System.out.println(ans);
    }
}
