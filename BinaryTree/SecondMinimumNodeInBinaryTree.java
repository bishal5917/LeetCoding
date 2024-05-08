package BinaryTree;

public class SecondMinimumNodeInBinaryTree {

    public int findSecondMinimumValue(TreeNode root) {
        long firstMin = getMinimumHelper(root, Long.MAX_VALUE, -1);
        long secondMin = getMinimumHelper(root, Long.MAX_VALUE, firstMin);
        return secondMin == Long.MAX_VALUE ? -1 : (int) secondMin;
    }

    private long getMinimumHelper(TreeNode root, long min, long discard) {
        if (root == null) {
            return min;
        }
        if (root.val != discard) {
            min = Math.min(root.val, min);
        }
        min = getMinimumHelper(root.left, min, discard);
        min = getMinimumHelper(root.right, min, discard);
        return min;
    }

    public static void main(String[] args) {
        SecondMinimumNodeInBinaryTree obj = new SecondMinimumNodeInBinaryTree();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println(obj.findSecondMinimumValue(root));
    }
}
