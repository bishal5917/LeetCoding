import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MaximumLevelSumInBinaryTree {

    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int maxSumLevel = 0;
        int currLevel = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return maxSum;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            currLevel += 1;
            int size = queue.size();
            int currSum = 0;
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                currSum += root.val;
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            if (currSum > maxSum) {
                maxSumLevel = currLevel;
                maxSum = currSum;
            }
        }
        return maxSumLevel;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(-8);
        MaximumLevelSumInBinaryTree obj = new MaximumLevelSumInBinaryTree();
        int ans = obj.maxLevelSum(root);
        System.out.println(ans);
    }

}
