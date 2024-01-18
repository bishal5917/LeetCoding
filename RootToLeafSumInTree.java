import java.util.ArrayList;
import java.util.List;

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

public class RootToLeafSumInTree {

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<String> branchBinary = new ArrayList<>();
        System.out.println(rangeSumBstHelper(root, branchBinary, ""));
        int sum = 0;
        for (String item : branchBinary) {
            int decimalEq = Integer.parseInt(item, 2);
            sum += decimalEq;
        }
        return sum;
    }

    private List<String> rangeSumBstHelper(TreeNode root, List<String> current, String oneBranch) {
        if (root == null) {
            return current;
        }
        oneBranch += String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            // means we are in leaf
            current.add(oneBranch);
            // set onebranch to "" once we get to null(leaf)(BACKTRACKING)
            oneBranch = "";
        }
        current = rangeSumBstHelper(root.left, current, oneBranch);
        current = rangeSumBstHelper(root.right, current, oneBranch);
        return current;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        RootToLeafSumInTree obj = new RootToLeafSumInTree();
        System.out.println(obj.sumRootToLeaf(root));
    }

}
