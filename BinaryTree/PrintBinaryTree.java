package BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintBinaryTree {

    int h = Integer.MIN_VALUE;

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> tree = new ArrayList<>();
        getTreeHeight(root, 0);
        // Now lets create a tree structure
        int rows = h;
        int cols = (int) Math.pow(2, h + 1) - 1;
        System.out.println(rows + "-" + cols);
        // create and arraylist
        for (int i = 0; i < rows + 1; i++) {
            List<String> vals = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                vals.add("");
            }
            tree.add(vals);
        }
        // Lets find the position of the root
        int r = 0;
        int c = (cols - 1) / 2;
        if (root == null)
            return tree;
        placeNodesHelper(tree, root, r, c);
        return tree;
    }

    private int getTreeHeight(TreeNode root, int height) {
        if (root == null) {
            return height;
        }
        h = Math.max(h, height);
        for (TreeNode child : Arrays.asList(root.left, root.right)) {
            if (child != null) {
                height += 1;
                height = getTreeHeight(child, height);
                height -= 1;
            }
        }
        return height;
    }

    private void placeNodesHelper(List<List<String>> tree, TreeNode root, int r, int c) {
        if (root == null) {
            return;
        }
        // place the node
        tree.get(r).set(c, String.valueOf(root.val));
        // Now place its left and right nodes recursively
        int posLeftCol = c - (int) Math.pow(2, h - r - 1);
        placeNodesHelper(tree, root.left, r + 1, posLeftCol);
        int posRightCol = c + (int) Math.pow(2, h - r - 1);
        placeNodesHelper(tree, root.right, r + 1, posRightCol);
    }

    public static void main(String[] args) {
        PrintBinaryTree obj = new PrintBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        System.out.println(obj.printTree(root));
    }
}
