package BinaryTree;

public class LongestZigZagPathInBinaryTree {

    int longest = Integer.MIN_VALUE;

    public int longestZigZag(TreeNode root) {
        dfsHelper(root, false, 0);
        dfsHelper(root, true, 0);
        return longest;
    }

    private int dfsHelper(TreeNode curr, boolean isLeft, int currLen) {
        if (curr == null) {
            return currLen;
        }
        // update the maxLength
        longest = Math.max(currLen, longest);
        // Then gotta go left or right
        if (isLeft) {
            currLen = dfsHelper(curr.left, false, currLen + 1);
            currLen = dfsHelper(curr.right, true, 1);
        } else {
            currLen = dfsHelper(curr.right, true, currLen + 1);
            currLen = dfsHelper(curr.left, false, 1);
        }
        return currLen;
    }

    public static void main(String[] args) {
        LongestZigZagPathInBinaryTree obj = new LongestZigZagPathInBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(1);
        root.left.right.left.right = new TreeNode(1);
        System.out.println(obj.longestZigZag(root));
    }
}
