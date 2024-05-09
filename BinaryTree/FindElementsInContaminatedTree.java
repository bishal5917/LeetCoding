package BinaryTree;

import java.util.HashSet;

public class FindElementsInContaminatedTree {

    HashSet<Integer> nodeSet;

    public FindElementsInContaminatedTree(TreeNode root) {
        nodeSet = new HashSet<>();
        if (root == null) {
            return;
        }
        TreeNode temp = root;
        temp.val = 0;
        nodeSet.add(0);
        decontaminateDfsHelper(temp);
    }

    public boolean find(int target) {
        return nodeSet.contains(target);
    }

    private void decontaminateDfsHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.val = 2 * root.val + 1;
            nodeSet.add(root.left.val);
        }
        if (root.right != null) {
            root.right.val = 2 * root.val + 2;
            nodeSet.add(root.right.val);
        }
        // Now go recursively for both left and right parts
        decontaminateDfsHelper(root.left);
        decontaminateDfsHelper(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(-1);
        root.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(-1);
        FindElementsInContaminatedTree obj = new FindElementsInContaminatedTree(root);
        System.out.println(obj.find(1));
        System.out.println(obj.find(3));
        System.out.println(obj.find(5));
    }

}
