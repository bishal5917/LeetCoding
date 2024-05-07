package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NAryLevelOrderTraversal {

    public List<List<Integer>> levelOrder(NAryNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        return bfsHelper(root);
    }

    // Using the classic BFS Technique
    private List<List<Integer>> bfsHelper(NAryNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<NAryNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                NAryNode curr = queue.poll();
                currLevel.add(curr.val);
                // Now add all its children
                if (curr.children == null) {
                    continue;
                }
                for (NAryNode child : curr.children) {
                    queue.offer(child);
                }
            }
            ans.add(currLevel);
        }
        return ans;
    }

    public static void main(String[] args) {
        NAryLevelOrderTraversal obj = new NAryLevelOrderTraversal();
        NAryNode root = new NAryNode(1);
        List<NAryNode> childs = new ArrayList<>();
        childs.add(new NAryNode(3));
        childs.add(new NAryNode(2));
        childs.add(new NAryNode(4));
        root.children = childs;
        System.out.println(obj.levelOrder(root));
    }
}