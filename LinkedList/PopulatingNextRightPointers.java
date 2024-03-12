package LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class PopulatingNextRightPointers {

    public Node connect(Node root) {
        if (root == null || root != null && root.left == null && root.right == null) {
            return root;
        }
        // lets first do a in-order traversal of a node using BFS
        Queue<Node> queue = new LinkedList<>();
        List<List<Node>> levels = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Node> currLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                currLevel.add(curr);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            levels.add(currLevel);
        }
        System.out.println(levels);
        connectRightPointers(levels);
        return root;
    }

    private void connectRightPointers(List<List<Node>> levels) {
        for (List<Node> level : levels) {
            for (int i = 0; i < level.size(); i++) {
                Node curr = level.get(i);
                Node next = null;
                if (i + 1 >= level.size()) {
                    next = null;
                } else {
                    next = level.get(i + 1);
                }
                curr.next = next;
            }
        }
    }

    public static void main(String[] args) {
        PopulatingNextRightPointers obj = new PopulatingNextRightPointers();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        obj.connect(root);
    }
}
