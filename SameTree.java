
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

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameTreeHelper(p, q);
    }

    public boolean isSameTreeHelper(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode rootA = new TreeNode(4);
        rootA.left = new TreeNode(2);
        rootA.right = new TreeNode(7);
        TreeNode rootB = new TreeNode(4);
        rootB.left = new TreeNode(2);
        rootB.right = new TreeNode(7);
        SameTree obj = new SameTree();
        System.out.println(obj.isSameTree(rootA, rootB));
    }
}
