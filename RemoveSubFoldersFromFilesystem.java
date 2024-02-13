import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

class FolderTrieNode {
    private HashMap<String, FolderTrieNode> children;
    private boolean isEndOfTheWord;

    FolderTrieNode(HashMap<String, FolderTrieNode> children, boolean isEndOfTheWord) {
        this.children = children;
        this.isEndOfTheWord = isEndOfTheWord;
    }

    public HashMap<String, FolderTrieNode> getChildren() {
        return children;
    }

    public void setChildren(HashMap<String, FolderTrieNode> children) {
        this.children = children;
    }

    public boolean isEndOfTheWord() {
        return isEndOfTheWord;
    }

    public void setEndOfTheWord(boolean isEndOfTheWord) {
        this.isEndOfTheWord = isEndOfTheWord;
    }

    @Override
    public String toString() {
        return "NODE [ children=" + children + ", isEnd=" + isEndOfTheWord + "]";
    }
}

class FolderTrie {

    private FolderTrieNode root;

    public FolderTrieNode getRoot() {
        return root;
    }

    public FolderTrie() {
        // instantiate a root node
        root = new FolderTrieNode(new HashMap<>(), false);
    }

    public void insert(String word) {
        String[] splittedWord = word.split("/");
        if (!root.getChildren().containsKey(splittedWord[0])) {
            // means that the first letter isn't present
            // get the children instance of root node
            FolderTrieNode curr;
            curr = root;
            HashMap<String, FolderTrieNode> childs = curr.getChildren();
            for (int i = 0; i < splittedWord.length; i++) {
                FolderTrieNode newNode = new FolderTrieNode(new HashMap<>(), false);
                // If we are at the last character , set End of word to true
                if (i == splittedWord.length - 1) {
                    newNode.setEndOfTheWord(true);
                }
                childs.put(splittedWord[i], newNode);
                curr.setChildren(childs);
                curr = newNode;
                childs = curr.getChildren();
            }
        } else {
            // means the children isnot null and the root already has the first letter
            // get the children instance of root node
            FolderTrieNode curr;
            curr = root;
            int index = 0;
            int stoppedIdx = 0;
            // Now we gotta keep going and set the curr node to the node which children have
            // no any more words present
            while (index < splittedWord.length) {
                if (curr.getChildren().containsKey(splittedWord[index])) {
                    curr = curr.getChildren().get(splittedWord[index]);
                    stoppedIdx = index;
                } else {
                    break;
                }
                index += 1;
            }
            // Now if we already found the whole word inside another word
            // we have to set that last one to the isEndOfTheWord = true
            if (stoppedIdx == splittedWord.length - 1) {
                // At last already , so set that word to atEnd=true and return;
                curr.setEndOfTheWord(true);
                return;
            }
            // else keep inserting normfoldersy
            HashMap<String, FolderTrieNode> childs = curr.getChildren();
            for (int i = stoppedIdx + 1; i < splittedWord.length; i++) {
                FolderTrieNode newNode = new FolderTrieNode(new HashMap<>(), false);
                // If we are at the last character , set End of word to true
                if (i == splittedWord.length - 1) {
                    newNode.setEndOfTheWord(true);
                }
                childs.put(splittedWord[i], newNode);
                curr = newNode;
                childs = curr.getChildren();
            }
            curr.setChildren(childs);
        }
    }
}

public class RemoveSubFoldersFromFilesystem {

    public List<String> removeSubfolders(String[] folder) {
        // Lets use our trie data structure
        FolderTrie trie = new FolderTrie();
        // insert folders the words to the trie
        for (String word : folder) {
            trie.insert(word);
        }
        // getting the root
        FolderTrieNode root = trie.getRoot();
        // Recursing finding folders the added paths till we get to the end
        return findFoldersRecursiveHelper(root.getChildren(), "", new ArrayList<>(),
                false, new ArrayList<>());
    }

    // Recursive backtracking approach to find folders
    // go till we reach the end of the string
    // after reaching backtrack and go for another key in entryset till we exhaust
    // all the possibilities
    List<String> findFoldersRecursiveHelper(HashMap<String, FolderTrieNode> childs, String key,
            List<String> curr, boolean isEndOfString, List<String> folders) {
        if (isEndOfString == true || childs.isEmpty()) {
            // if end of string is reached
            // convert the array to string by adding / and append to result
            folders.add(String.join("/", curr));
            return folders;
        }
        // go for folders entrysets for that key
        for (Map.Entry<String, FolderTrieNode> entry : childs.entrySet()) {
            // Keep adding to the current
            curr.add(entry.getKey());
            // go for another one recursively
            folders = findFoldersRecursiveHelper(childs.get(entry.getKey()).getChildren(), entry.getKey(), curr,
                    childs.get(entry.getKey()).isEndOfTheWord(), folders);
            // Start backtracking while stack starts to unwind to reach another possibility
            curr.remove(curr.size() - 1);
        }
        return folders;
    }

    public static void main(String[] args) {
        RemoveSubFoldersFromFilesystem obj = new RemoveSubFoldersFromFilesystem();
        String[] folder = { "/a", "/a/b", "/c/d", "/c/d/e", "/c/f" };
        List<String> ans = obj.removeSubfolders(folder);
        System.out.println(ans);

    }

}
