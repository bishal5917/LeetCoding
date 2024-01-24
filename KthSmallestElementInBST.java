import java.util.ArrayList;
import java.util.List;

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

public class KthSmallestElementInBST {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inOrderTraversal = inOrderTraversal(root,new ArrayList<>());
        return inOrderTraversal.get(k-1);
    }

    private List<Integer> inOrderTraversal(TreeNode root,List<Integer> ans){
        if (root==null){
            return ans;
        }
        ans = inOrderTraversal(root.left, ans);
        ans.add(root.val);
        ans = inOrderTraversal(root.right, ans);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        KthSmallestElementInBST obj = new KthSmallestElementInBST();
        Object ans = obj.kthSmallest(root,1);
        System.out.println(ans);
    }
}
