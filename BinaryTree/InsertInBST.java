package BinaryTree;

public class InsertInBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) {
            root = newNode;
            return root;
        }
        insert(root, newNode);
        return root;
    }

    private void insert(TreeNode root, TreeNode node) {
        if (root.left == null && root.right == null) {
            if (node.val < root.val) {
                root.left = node;
                return;
            } else {
                root.right = node;
                return;
            }
        }
        if (root.left == null && node.val < root.val) {
            root.left = node;
            return;
        }
        if (root.right == null && node.val > root.val) {
            root.right = node;
            return;
        }
        if (node.val > root.val) {
            insert(root.right, node);
        } else {
            insert(root.left, node);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        InsertInBST obj = new InsertInBST();
        System.out.println(obj.insertIntoBST(root, 5).val);
    }
}
