import java.util.HashSet;
import java.util.Set;

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

public class TwoSumInBst {

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        return bstTwoSumHelper(root, k, new HashSet<>());
    }

    private boolean bstTwoSumHelper(TreeNode root, int target, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        // do some logic
        if (set.contains(target - root.val)) {
            return true;
        }
        set.add(root.val);
        return bstTwoSumHelper(root.left, target, set) || bstTwoSumHelper(root.right, target, set);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        TwoSumInBst obj = new TwoSumInBst();
        System.out.println(obj.findTarget(root, 7));
    }
}
