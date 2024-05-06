package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBst {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> arr1 = findInOrderTraversal(root1, new ArrayList<>());
        List<Integer> arr2 = findInOrderTraversal(root2, new ArrayList<>());
        System.out.println(arr1);
        System.out.println(arr2);
        return mergeSortedArrays(arr1, arr2);
    }

    private List<Integer> findInOrderTraversal(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return nodes;
        }
        findInOrderTraversal(root.left, nodes);
        nodes.add(root.val);
        findInOrderTraversal(root.right, nodes);
        return nodes;
    }

    private List<Integer> mergeSortedArrays(List<Integer> arr1, List<Integer> arr2) {
        List<Integer> mergedArray = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) < arr2.get(j)) {
                mergedArray.add(arr1.get(i));
                i += 1;
            } else {
                mergedArray.add(arr2.get(j));
                j += 1;
            }
        }
        while (i < arr1.size()) {
            mergedArray.add(arr1.get(i));
            i += 1;
        }
        while (j < arr2.size()) {
            mergedArray.add(arr2.get(j));
            j += 1;
        }
        return mergedArray;
    }

    public static void main(String[] args) {
        TreeNode rootA = new TreeNode(2);
        rootA.left = new TreeNode(1);
        rootA.right = new TreeNode(4);
        rootA.right.right = new TreeNode(5);
        TreeNode rootB = new TreeNode(1);
        rootB.left = new TreeNode(0);
        rootB.right = new TreeNode(3);
        AllElementsInTwoBst obj = new AllElementsInTwoBst();
        List<Integer> ans = obj.getAllElements(rootA, rootB);
        System.out.println(ans);
    }
}
