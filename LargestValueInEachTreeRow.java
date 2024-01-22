import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
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

public class LargestValueInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> maxValues = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return maxValues;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int currMax = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                currMax = Math.max(currMax, root.val);
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            maxValues.add(currMax);
        }
        return maxValues;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        LargestValueInEachTreeRow obj = new LargestValueInEachTreeRow();
        List<Integer> ans = obj.largestValues(root);
        System.out.println(ans);
    }
}
