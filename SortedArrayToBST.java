
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

public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return recursiveBstHelper(nums,0,nums.length-1);
    }

    private TreeNode recursiveBstHelper(int[] nums, int left, int right) {
        if (left>right){
            return null;
        }
        int mid = left + (right-left)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = recursiveBstHelper(nums, left, mid-1);
        node.right = recursiveBstHelper(nums, mid+1, right);
        return node;
       }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        SortedArrayToBST obj = new SortedArrayToBST();
        System.out.println(obj.sortedArrayToBST(nums));
    }
}
