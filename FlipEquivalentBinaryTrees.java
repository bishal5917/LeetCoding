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

public class FlipEquivalentBinaryTrees {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return checkEquivalentHelper(root1, root2);
    }

    private boolean checkEquivalentHelper(TreeNode rootA, TreeNode rootB) {
        if (rootA == null && rootB == null) {
            return true;
        }
        if (rootA == null || rootB == null) {
            return false;
        }
        if (rootA.val != rootB.val) {
            return false;
        }
        return (checkEquivalentHelper(rootA.left, rootB.left) && checkEquivalentHelper(rootA.right, rootB.right)) ||
                (checkEquivalentHelper(rootA.left, rootB.right) && checkEquivalentHelper(rootA.right, rootB.left));
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        FlipEquivalentBinaryTrees obj = new FlipEquivalentBinaryTrees();
        boolean ans = obj.flipEquiv(root1, root2);
        System.out.println(ans);
    }

}
