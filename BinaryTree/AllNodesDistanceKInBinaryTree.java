package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllNodesDistanceKInBinaryTree {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // Lets create an adjacency list/graph from trees
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        createGraph(root, graph);
        // Now lets perform BFS from the target for k times
        System.out.println(graph);
        return bfsHelper(graph, target.val, k);
    }

    private List<Integer> bfsHelper(HashMap<Integer, List<Integer>> graph,
            int target, int k) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        while (!queue.isEmpty()) {
            if (k == 0) {
                return new ArrayList<>(queue);
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                // Add its neighbors if not visited yet
                if (!graph.containsKey(curr))
                    continue;
                for (int neighb : graph.get(curr)) {
                    if (!visited.contains(neighb)) {
                        queue.offer(neighb);
                        visited.add(neighb);
                    }
                }
            }
            k -= 1;
        }
        return new ArrayList<>();
    }

    private void createGraph(TreeNode curr, HashMap<Integer, List<Integer>> graph) {
        if (curr == null) {
            return;
        }
        List<TreeNode> childs = new ArrayList<>();
        if (curr.left != null)
            childs.add(curr.left);
        if (curr.right != null)
            childs.add(curr.right);
        for (TreeNode child : childs) {
            graph.putIfAbsent(curr.val, new ArrayList<>());
            graph.get(curr.val).add(child.val);
            graph.putIfAbsent(child.val, new ArrayList<>());
            graph.get(child.val).add(curr.val);
            createGraph(child, graph);
        }
    }

    public static void main(String[] args) {
        AllNodesDistanceKInBinaryTree obj = new AllNodesDistanceKInBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        System.out.println(obj.distanceK(root, new TreeNode(5), 2));
    }
}
