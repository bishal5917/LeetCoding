package BinaryTree;

public class CountGoodNodesInBinaryTree {

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfsHelper(root, root.val, 0);
    }

    private int dfsHelper(TreeNode root, int currMax, int count) {
        if (root == null) {
            return count;
        }
        // Now check if its a good node
        if (root.val >= currMax) {
            // Means a good node,increment count
            currMax = root.val;
            count += 1;
        }
        // Recursively check for left and the right subtree
        count = dfsHelper(root.left, currMax, count);
        count = dfsHelper(root.right, currMax, count);
        return count;
    }

    public static void main(String[] args) {
        CountGoodNodesInBinaryTree obj = new CountGoodNodesInBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(obj.goodNodes(root));
    }
}
