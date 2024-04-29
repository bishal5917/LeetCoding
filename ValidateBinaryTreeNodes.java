import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ValidateBinaryTreeNodes {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        // lets calculate their indegrees and then create an adjacency list
        int[] indegree = new int[n];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        // Lets go for left child and right child
        for (int i = 0; i < n; i++) {
            List<Integer> nebs = new ArrayList<>();
            if (leftChild[i] != -1) {
                nebs.add(leftChild[i]);
                indegree[leftChild[i]] += 1;
            }
            if (rightChild[i] != -1) {
                nebs.add(rightChild[i]);
                indegree[rightChild[i]] += 1;
            }
            graph.put(i, nebs);
        }
        System.out.println(graph);
        // calculate roots,if more than 1 roots return
        int roots = 0;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                roots += 1;
            }
        }
        if (roots == 0 || roots > 1) {
            return false;
        }
        for (int i = 0; i < indegree.length; i++) {
            boolean check = bfsHelper(graph, i);
            if (check == false) {
                return false;
            }
        }
        return true;
    }

    private boolean bfsHelper(HashMap<Integer, List<Integer>> graph, int root) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            // add all its neighbors
            // while adding neighbors,check if they are visited already,
            // if visited already,they had another parent,so return false
            for (int child : graph.get(curr)) {
                if (visited.contains(child)) {
                    return false;
                }
                visited.add(child);
                queue.offer(child);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidateBinaryTreeNodes obj = new ValidateBinaryTreeNodes();
        int n = 4;
        int[] leftChild = { 1, 0, 3, -1 };
        int[] rightChild = { -1, -1, -1, -1 };
        System.out.println(obj.validateBinaryTreeNodes(n, leftChild, rightChild));
    }
}
