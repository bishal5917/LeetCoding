package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        return findPathsHelper(root, new ArrayList<>(), "");
    }

    public List<String> findPathsHelper(TreeNode root, List<String> paths, String currPath) {
        if (root == null) {
            return paths;
        }
        if (currPath.length() == 0) {
            currPath = currPath + root.val;
        } else {
            currPath = currPath + "->";
            currPath = currPath + root.val;
        }
        if (root.left == null && root.right == null) {
            // means no more paths we are at the leaf
            // backtrack
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
        BinaryTreePaths obj = new BinaryTreePaths();
        List<String> paths = obj.binaryTreePaths(root);
        System.out.println(paths);
    }
}
