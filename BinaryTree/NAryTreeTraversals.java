package BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NAryTreeTraversals {

    public List<Integer> postorder(NAryNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> postOrder = new ArrayList<>();
        postOrderDfsHelper(root, postOrder);
        postOrder.add(root.val);
        return postOrder;
    }

    private List<Integer> postOrderDfsHelper(NAryNode root, List<Integer> order) {
        if (root.children == null) {
            return order;
        }
        for (NAryNode child : root.children) {
            order = postOrderDfsHelper(child, order);
            order.add(child.val);
        }
        return order;
    }

    public List<Integer> preorder(NAryNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> preOrder = new ArrayList<>();
        preOrderDfsHelper(root, preOrder);
        return preOrder;
    }

    private List<Integer> preOrderDfsHelper(NAryNode root, List<Integer> order) {
        order.add(root.val);
        if (root.children == null) {
            return order;
        }
        for (NAryNode child : root.children) {
            order = preOrderDfsHelper(child, order);
        }
        return order;
    }

    public static void main(String[] args) {
        NAryTreeTraversals obj = new NAryTreeTraversals();
        NAryNode root = new NAryNode(1);
        List<NAryNode> childs = new ArrayList<>();
        childs.add(new NAryNode(3));
        childs.add(new NAryNode(2));
        childs.add(new NAryNode(4));
        root.children = childs;
        root.children.get(0).children = new ArrayList<>(
                Arrays.asList(new NAryNode(5), new NAryNode(6)));
        // System.out.println(obj.postorder(root));
        System.out.println(obj.preorder(root));
    }
}
