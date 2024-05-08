package BinaryTree;

import java.util.Arrays;

public class CousinsInBinaryTree {

    int depthX = -1;
    int depthY = -1;
    int parentX = -1;
    int parentY = -1;

    public boolean isCousins(TreeNode root, int x, int y) {
        // Gotta find the heights and parents of X&Y
        dfsHelper(root, 0, x, y);
        // System.out.println(depthX + "-" + depthY);
        // System.out.println(parentX + "-" + parentY);
        return depthX == depthY && parentX != parentY;
    }

    private int dfsHelper(TreeNode root, int currDepth, int x, int y) {
        if (root == null) {
            return currDepth;
        }
        if (root.val == x) {
            depthX = currDepth;
        }
        if (root.val == y) {
            depthY = currDepth;
        }
        // Now time to go for the childs
        for (TreeNode child : Arrays.asList(root.left, root.right)) {
            if (child != null) {
                // Lets update the parents if possible
                if (child.val == x) {
                    parentX = root.val;
                }
                if (child.val == y) {
                    parentY = root.val;
                }
                currDepth += 1;
                currDepth = dfsHelper(child, currDepth, x, y);
                currDepth -= 1;
            }
        }
        return currDepth;
    }

    public static void main(String[] args) {
        CousinsInBinaryTree obj = new CousinsInBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(obj.isCousins(root, 5, 4));
    }
}
