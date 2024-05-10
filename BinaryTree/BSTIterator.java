package BinaryTree;

import java.util.Stack;

public class BSTIterator {

    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        pushLefts(root);
    }

    public int next() {
        TreeNode nextOne = st.pop();
        pushLefts(nextOne.right);
        return nextOne.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void pushLefts(TreeNode node) {
        while (node != null) {
            st.push(node);
            node = node.left;
        }
    }

    public static void main(String[] args) {
    }
}
