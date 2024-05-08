package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class MaxDepthOfNAryTree {

    int maxDepth = Integer.MIN_VALUE;

    public int maxDepth(NAryNode root) {
        if (root == null) {
            return 0;
        }
        maxDepth = 1;
        dfsHelper(root, 1);
        return maxDepth;
    }

    private int dfsHelper(NAryNode root, int currDepth) {
        if (root.children == null) {
            return currDepth;
        }
        // Go to depth for every children
        for (NAryNode child : root.children) {
            currDepth += 1;
            currDepth = dfsHelper(child, currDepth);
            maxDepth = Math.max(currDepth, maxDepth);
            currDepth -= 1;
        }
        return currDepth;
    }

    public static void main(String[] args) {
        MaxDepthOfNAryTree obj = new MaxDepthOfNAryTree();
        NAryNode root = new NAryNode(1);
        List<NAryNode> childs = new ArrayList<>();
        NAryNode nodeThree = new NAryNode(3);
        childs.add(nodeThree);
        childs.add(new NAryNode(2));
        childs.add(new NAryNode(4));
        root.children = childs;
        List<NAryNode> childsOf3 = new ArrayList<>();
        childs.add(new NAryNode(5));
        childs.add(new NAryNode(6));
        nodeThree.children = childsOf3;
        System.out.println(obj.maxDepth(root));
    }
}
