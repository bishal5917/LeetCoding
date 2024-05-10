package BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstructStringFromBinaryTree {

    public String tree2str(TreeNode root) {
        StringBuilder str = new StringBuilder();
        if (root == null) {
            return str.toString();
        }
        str.append(root.val);
        return dfsHelper(root, str).toString();
    }

    private StringBuilder dfsHelper(TreeNode root, StringBuilder str) {
        if (root == null) {
            return str;
        }
        // else go for its childs
        List<TreeNode> childs = new ArrayList<>(Arrays.asList(root.left, root.right));
        for (int i = 0; i < childs.size(); i++) {
            TreeNode child = childs.get(i);
            if (i == 0 && child == null && childs.get(1) != null) {
                str.append('(');
                str.append(')');
                continue;
            }
            if (i == 1 && child == null) {
                continue;
            }
            if (child != null) {
                str.append('(');
                str.append(child.val);
                str = dfsHelper(child, str);
                str.append(')');
            }
        }
        return str;
    }

    public static void main(String[] args) {
        ConstructStringFromBinaryTree obj = new ConstructStringFromBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(obj.tree2str(root));
    }
}
