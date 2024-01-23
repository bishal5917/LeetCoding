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

//THIS QUESTION IS SAME AS : LOWEST COMMON ANCESTOR OF DEEPEST LEAVES ( Q.1123 )
public class SmallestSubtreeWithAllDeepestNodes {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return findDeepestRootHelper(root, root);
    }

    private int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftPart = findHeight(root.left);
        int rightPart = findHeight(root.right);
        return Math.max(leftPart, rightPart) + 1;
    }

    private TreeNode findDeepestRootHelper(TreeNode root, TreeNode smallestSoFar) {
        if (root == null) {
            return smallestSoFar;
        }
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        if (leftHeight > rightHeight) {
            smallestSoFar = findDeepestRootHelper(root.left, smallestSoFar);
        } else if (leftHeight < rightHeight) {
            smallestSoFar = findDeepestRootHelper(root.right, smallestSoFar);
        } else {
            smallestSoFar = root;
        }
        return smallestSoFar;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        SmallestSubtreeWithAllDeepestNodes obj = new SmallestSubtreeWithAllDeepestNodes();
        TreeNode ans = obj.subtreeWithAllDeepest(root);
        System.out.println(ans.val);
    }
}