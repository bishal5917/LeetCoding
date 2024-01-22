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

public class BinaryTreeSumRootToLeaf {

    public int sumNumbers(TreeNode root) {
        List<String> sumStrings = findPathsHelper(root, new ArrayList<>(), "");
        int finalSum = 0;
        for (String item : sumStrings) {
            int intValue = Integer.parseInt(item);
            finalSum += intValue;
        }
        return finalSum;
    }

    public List<String> findPathsHelper(TreeNode root, List<String> paths, String currPath) {
        if (root == null) {
            return paths;
        }
        currPath = currPath + root.val;
        if (root.left == null && root.right == null) {
            // means no more paths we are at the leaf, so backtrack
            paths.add(currPath);
            currPath = "";
        }
        paths = findPathsHelper(root.left, paths, currPath);
        paths = findPathsHelper(root.right, paths, currPath);
        return paths;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        BinaryTreeSumRootToLeaf obj = new BinaryTreeSumRootToLeaf();
        int sum = obj.sumNumbers(root);
        System.out.println(sum);
    }
}
