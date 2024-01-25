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

public class CountNodesEqualToAverageOfSubtree {

    public int averageOfSubtree(TreeNode root) {
        return findAverageNodesHelper(root);
    }

    private int findAverageNodesHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int currentCount = (root.val == findSubtreeSum(root, 0) / countNodesInSubtree(root)) ? 1 : 0;
        int leftCount = findAverageNodesHelper(root.left);
        int rightCount = findAverageNodesHelper(root.right);

        return currentCount + leftCount + rightCount;
    }

    private int findSubtreeSum(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        sum += root.val;
        sum = findSubtreeSum(root.left, sum);
        sum = findSubtreeSum(root.right, sum);
        return sum;
    }

    private int countNodesInSubtree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int nodes = 0;
        if (root == null) {
            return nodes;
        }
        queue.offer(root);
        nodes += 1;
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.left != null) {
                queue.add(root.left);
                nodes += 1;
            }
            if (root.right != null) {
                queue.add(root.right);
                nodes += 1;
            }
        }
        return nodes;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(6);
        CountNodesEqualToAverageOfSubtree obj = new CountNodesEqualToAverageOfSubtree();
        int ans = obj.averageOfSubtree(root);
        System.out.println(ans);
    }
}
