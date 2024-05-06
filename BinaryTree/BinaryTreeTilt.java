package BinaryTree;

public class BinaryTreeTilt {

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        findTiltHelper(root);
        int tiltVal = Math.abs(allChildSum(root.left, root.val) + allChildSum(root.right, 0));
        return tiltVal;
    }

    public void findTiltHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            root.val = 0;
            return;
        }
        int leftSum = allChildSum(root.left, root.val);
        int rightSum = allChildSum(root.right, root.val);
        int diff = Math.abs(leftSum - rightSum);
        root.val = diff;
        findTiltHelper(root.left);
        findTiltHelper(root.right);
    }

    private int allChildSum(TreeNode node, int sum) {
        if (node == null) {
            return sum;
        }
        sum = sum + node.val;
        sum = allChildSum(node.left, sum);
        sum = allChildSum(node.right, sum);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        BinaryTreeTilt obj = new BinaryTreeTilt();
        int ans = obj.findTilt(root);
        System.out.println(ans);
    }
}
