import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class PseudoPalindromicPathsInABinaryTree {

    public int pseudoPalindromicPaths(TreeNode root) {
        return pseudoPalindromicPathCounterHelper(root, 0, "");
    }

    private int pseudoPalindromicPathCounterHelper(TreeNode root, int count, String path) {
        if (root == null) {
            return count;
        }
        path += String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            if (checkIfPathIsPseudoPalindromic(path.toString())) {
                count += 1;
            }
            path = "";
        }
        count = pseudoPalindromicPathCounterHelper(root.left, count, path);
        count = pseudoPalindromicPathCounterHelper(root.right, count, path);
        return count;
    }

    // For the number to be pseudopalindromic, it should satisfy the condition that
    // at most one digit occurs an odd
    // number of times,and all other digits occur an even number of times.
    private boolean checkIfPathIsPseudoPalindromic(String path) {
        HashMap<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < path.length(); i++) {
            char currChar = path.charAt(i);
            if (counts.get(currChar) == null) {
                counts.put(currChar, 1);
            } else {
                int currentCount = counts.get(currChar);
                counts.put(currChar, currentCount + 1);
            }
        }
        int evenCount = 0;
        int oddCount = 0;
        for (char item : counts.keySet()) {
            if (oddCount > 1) {
                return false;
            }
            if (counts.get(item) % 2 == 0) {
                evenCount += 1;
            } else {
                oddCount += 1;
            }
        }
        if (oddCount <= 1 && oddCount + evenCount == counts.size()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        PseudoPalindromicPathsInABinaryTree obj = new PseudoPalindromicPathsInABinaryTree();
        System.out.println(obj.pseudoPalindromicPaths(root));
    }
}
