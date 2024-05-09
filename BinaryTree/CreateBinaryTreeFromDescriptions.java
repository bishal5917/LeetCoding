package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateBinaryTreeFromDescriptions {

    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        HashMap<Integer, Integer> parentChildMap = new HashMap<>();
        for (int[] desc : descriptions) {
            int parent = desc[0];
            int child = desc[1];
            map.putIfAbsent(parent, new ArrayList<>());
            map.get(parent).add(new int[] { child, desc[2] });
            // Now update the parent to child
            if (parentChildMap.get(parent) == null) {
                parentChildMap.put(parent, -1);
            }
            parentChildMap.put(child, parent);
        }
        System.out.println(map);
        System.out.println(parentChildMap);
        // Now the node that has -1 value is the root
        TreeNode root = null;
        for (Map.Entry<Integer, Integer> entry : parentChildMap.entrySet()) {
            if (entry.getValue() == -1) {
                root = new TreeNode(entry.getKey());
                break;
            }
        }
        createTreeDfsHelper(root, map);
        return root;
    }

    private void createTreeDfsHelper(TreeNode root, HashMap<Integer, List<int[]>> map) {
        if (map.get(root.val) == null) {
            return;
        }
        // Now keep creating from the childs
        for (int[] child : map.get(root.val)) {
            // get the child information,if value and position
            int value = child[0];
            int isLeft = child[1];
            // create a new node
            TreeNode childNode = new TreeNode(value);
            if (isLeft == 1) {
                root.left = childNode;
                createTreeDfsHelper(root.left, map);
            } else {
                root.right = childNode;
                createTreeDfsHelper(root.right, map);
            }
        }
    }

    public static void main(String[] args) {
        CreateBinaryTreeFromDescriptions obj = new CreateBinaryTreeFromDescriptions();
        int[][] descriptions = { { 20, 15, 1 }, { 20, 17, 0 }, { 50, 20, 1 }, { 50, 80, 0 }, { 80, 19, 1 } };
        System.out.println(obj.createBinaryTree(descriptions));
    }
}
