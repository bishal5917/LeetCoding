
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

public class RangeSumBst {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root==null){
            return 0;
        }
        return rangeSumBstHelper(root,low,high,0);
    }

    private int rangeSumBstHelper(TreeNode root, int low, int high,int currRangeSum) {
        if (root == null) {
            return currRangeSum;
        }
        if (root.val>=low && root.val<=high){
            currRangeSum=currRangeSum+root.val;
        }
        currRangeSum = rangeSumBstHelper(root.left, low, high, currRangeSum);
        currRangeSum = rangeSumBstHelper(root.right, low, high, currRangeSum);
        return currRangeSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        RangeSumBst obj = new RangeSumBst();
        System.out.println(obj.rangeSumBST(root, 7,15));
    }

}
