package BinaryTree;

import java.util.Arrays;

public class SmallestStringStartingFromLeaf {

    String smallestString = "";

    public String smallestFromLeaf(TreeNode root) {
        StringBuilder curr = new StringBuilder();
        curr.append((char) (root.val + 'a'));
        dfsHelper(root, curr);
        return smallestString;
    }

    // Lets construct the string from root to leaf
    private StringBuilder dfsHelper(TreeNode node, StringBuilder curr) {
        if (node.left == null && node.right == null) {
            // Now check for the smallest string
            curr.reverse();
            if (smallestString.isEmpty()) {
                smallestString = curr.toString();
            } else {
                // compare lexically smaller one
                int res = smallestString.compareTo(curr.toString());
                if (res > 0) {
                    smallestString = curr.toString();
                }
            }
            curr.reverse();
            System.out.println(curr.toString());
        }
        for (TreeNode child : Arrays.asList(node.left, node.right)) {
            if (child != null) {
                curr.append((char) (child.val + 'a'));
                curr = dfsHelper(child, curr);
                curr.deleteCharAt(curr.length() - 1);
            }
        }
        return curr;
    }

    public static void main(String[] args) {
        SmallestStringStartingFromLeaf obj = new SmallestStringStartingFromLeaf();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(obj.smallestFromLeaf(root));
    }
}
