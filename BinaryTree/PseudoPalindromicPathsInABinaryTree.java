package BinaryTree;

import java.util.Arrays;

public class PseudoPalindromicPathsInABinaryTree {

    public int pseudoPalindromicPaths(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // Numbers are from 1-9
        // so we can count on Array instead of HASHMAP
        int[] counts = new int[10];
        counts[root.val] += 1;
        return dfsHelper(root, counts, 0);
    }

    // Lets do a traversal
    private int dfsHelper(TreeNode root, int[] counts, int count) {
        if (root == null) {
            return count;
        }
        if (root.left == null && root.right == null) {
            // check if its pseudoPalindromic
            if (isPseudoPalindromic(counts)) {
                count += 1;
            }
        }
        // Now traverse recursively
        for (TreeNode child : Arrays.asList(root.left, root.right)) {
            if (child == null) {
                continue;
            }
            counts[child.val] += 1;
            count = dfsHelper(child, counts, count);
            counts[child.val] -= 1;
        }
        return count;
    }

    private boolean isPseudoPalindromic(int[] counts) {
        // odds cant be more than 1 to become palindromic
        int odds = 0;
        for (int i = 1; i <= 9; i++) {
            if (counts[i] % 2 != 0) {
                odds += 1;
            }
            if (odds > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        PseudoPalindromicPathsInABinaryTree obj = new PseudoPalindromicPathsInABinaryTree();
        System.out.println(obj.pseudoPalindromicPaths(root));
    }
}
