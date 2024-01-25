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

public class SumOfNodesWithEvenValuedGrandparents {

    public int sumEvenGrandparent(TreeNode root) {
        return sumNodesWithEvenValuedPopsHelper(root, 0);
    }

    private int sumNodesWithEvenValuedPopsHelper(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        if (root.val % 2 == 0) {
            if (root.left != null && root.left.left != null) {
                sum += root.left.left.val;
            }
            if (root.left != null && root.left.right != null) {
                sum += root.left.right.val;
            }
            if (root.right != null && root.right.left != null) {
                sum += root.right.left.val;
            }
            if (root.right != null && root.right.right != null) {
                sum += root.right.right.val;
            }
        }
        sum = sumNodesWithEvenValuedPopsHelper(root.left, sum);
        sum = sumNodesWithEvenValuedPopsHelper(root.right, sum);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(7);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(9);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        SumOfNodesWithEvenValuedGrandparents obj = new SumOfNodesWithEvenValuedGrandparents();
        int ans = obj.sumEvenGrandparent(root);
        System.out.println(ans);
    }
}
