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

public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> tree1Leaves = new ArrayList<>();
        List<Integer> tree2Leaves = new ArrayList<>();
        tree1Leaves = leavesFinder(root1, tree1Leaves);
        tree2Leaves = leavesFinder(root2, tree2Leaves);
        System.out.println(tree1Leaves);
        System.out.println(tree2Leaves);
        return tree1Leaves.equals(tree2Leaves);
        // if (tree1Leaves.size() != tree2Leaves.size()) {
        //     return false;
        // }
        // int i = 0;
        // while (i < tree1Leaves.size() && i < tree2Leaves.size()) {
        //     if (tree1Leaves.get(i) != tree2Leaves.get(i)) {
        //         return false;
        //     }
        //     i += 1;
        // }
        // return true;
    }

    private List<Integer> leavesFinder(TreeNode root, List<Integer> leafSumArray) {
        if (root == null) {
            return leafSumArray;
        }
        if (root.left == null && root.right == null) {
            leafSumArray.add(root.val);
            return leafSumArray;
        }
        leafSumArray = leavesFinder(root.left, leafSumArray);
        leafSumArray = leavesFinder(root.right, leafSumArray);
        return leafSumArray;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(200);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(200);
        LeafSimilarTrees obj = new LeafSimilarTrees();
        System.out.println(obj.leafSimilar(root1, root2));
    }

}
