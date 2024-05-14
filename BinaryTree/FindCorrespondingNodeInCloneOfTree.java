package BinaryTree;

import java.util.Arrays;

public class FindCorrespondingNodeInCloneOfTree {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (target == null) {
            return null;
        }
        return dfsHelper(cloned, target, null);
    }

    private TreeNode dfsHelper(TreeNode root, TreeNode target, TreeNode ref) {
        if (root == null) {
            return ref;
        }
        if (root.val == target.val) {
            ref = root;
            return ref;
        }
        for (TreeNode child : Arrays.asList(root.left, root.right)) {
            if (child != null) {
                ref = dfsHelper(child, target, ref);
                if (ref != null) {
                    // means found,return
                    return ref;
                }
            }
        }
        return ref;
    }

    public static void main(String[] args) {
        // o=Original Tree,c=Cloned Tree
        FindCorrespondingNodeInCloneOfTree obj = new FindCorrespondingNodeInCloneOfTree();
        TreeNode o = new TreeNode(7);
        o.left = new TreeNode(4);
        o.right = new TreeNode(3);
        o.right.left = new TreeNode(6);
        o.right.right = new TreeNode(19);
        TreeNode c = new TreeNode(7);
        c.left = new TreeNode(4);
        c.right = new TreeNode(3);
        c.right.left = new TreeNode(6);
        c.right.right = new TreeNode(19);
        TreeNode target = new TreeNode(3);
        System.out.println(obj.getTargetCopy(o, c, target).val);
    }
}
