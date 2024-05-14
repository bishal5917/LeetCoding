package BinaryTree;

public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return createTreeRecursiveHelper(nums, 0, nums.length);
    }

    private TreeNode createTreeRecursiveHelper(int[] nums, int l, int r) {
        if (l >= r) {
            return null;
        }
        int maxIdx = findMaxIdx(nums, l, r);
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = createTreeRecursiveHelper(nums, l, maxIdx);
        root.right = createTreeRecursiveHelper(nums, maxIdx + 1, r);
        return root;
    }

    private int findMaxIdx(int[] nums, int l, int r) {
        int maxIdx = l;
        for (int i = l; i < r; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    public static void main(String[] args) {
        MaximumBinaryTree obj = new MaximumBinaryTree();
        int[] nums = { 3, 2, 1, 6, 0, 5 };
        System.out.println(obj.constructMaximumBinaryTree(nums).val);
    }
}
