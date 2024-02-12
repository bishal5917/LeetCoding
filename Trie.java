import java.util.HashMap;

class TrieNode {
    private HashMap<Character, TrieNode> children;
    private boolean isEndOfTheWord;

    TrieNode(HashMap<Character, TrieNode> children, boolean isEndOfTheWord) {
        this.children = children;
        this.isEndOfTheWord = isEndOfTheWord;
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(HashMap<Character, TrieNode> children) {
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

// THIS IS A PREFIX TRIE
// HOWEVER FOR BUILDING A PREFIX TRIE ,JUST ALTER THE INSERTION AND CHECKING
// PROCESS (FROM END OF WORD - > START OF THE WORD)

public class Trie {

    private TrieNode root;

    public Trie() {
        // instantiate a root node
        root = new TrieNode(new HashMap<>(), false);
    }

    public void insert(String word) {
        if (!root.getChildren().containsKey(word.charAt(0))) {
            // means that the first letter isn't present
            // get the children instance of root node
            TrieNode curr;
            curr = root;
            HashMap<Character, TrieNode> childs = curr.getChildren();
            for (int i = 0; i < word.length(); i++) {
                TrieNode newNode = new TrieNode(new HashMap<>(), false);
                // If we are at the last character , set End of word to true
                if (i == word.length() - 1) {
                    newNode.setEndOfTheWord(true);
                }
                childs.put(word.charAt(i), newNode);
                curr.setChildren(childs);
                curr = newNode;
                childs = curr.getChildren();
            }
        } else {
            // means the children isnot null and the root already has the first letter
            // get the children instance of root node
            TrieNode curr;
            curr = root;
            int index = 0;
            int stoppedIdx = 0;
            // Now we gotta keep going and set the curr node to the node which children have
            // no any more words present
            while (index < word.length()) {
                if (curr.getChildren().containsKey(word.charAt(index))) {
                    curr = curr.getChildren().get(word.charAt(index));
                    stoppedIdx = index;
                } else {
                    break;
                }
                index += 1;
            }
            // Now if we already found the whole word inside another word
            // we have to set that last one to the isEndOfTheWord = true
            if (stoppedIdx == word.length() - 1) {
                // At last already , so set that word to atEnd=true and return;
                curr.setEndOfTheWord(true);
                return;
            }
            // else keep inserting normally
            HashMap<Character, TrieNode> childs = curr.getChildren();
            for (int i = stoppedIdx + 1; i < word.length(); i++) {
                TrieNode newNode = new TrieNode(new HashMap<>(), false);
                // If we are at the last character , set End of word to true
                if (i == word.length() - 1) {
                    newNode.setEndOfTheWord(true);
                }
                childs.put(word.charAt(i), newNode);
                curr = newNode;
                childs = curr.getChildren();
            }
            curr.setChildren(childs);
        }
    }

    public boolean search(String word) {
        TrieNode curr;
        curr = root;
        int count = 0;
        HashMap<Character, TrieNode> childs = curr.getChildren();
        for (int i = 0; i < word.length(); i++) {
            if (childs.containsKey(word.charAt(i))) {
                if (i == word.length() - 1) {
                    // means at last idx,in this case end of the word must be marked as true
                    if (childs.get(word.charAt(i)).isEndOfTheWord() == true) {
                        count += 1;
                    }
                } else {
                    count += 1;
                }
                childs = childs.get(word.charAt(i)).getChildren();
            } else {
                break;
            }
        }
        return count == word.length();
    }

    public boolean startsWith(String prefix) {
        TrieNode curr;
        curr = root;
        HashMap<Character, TrieNode> childs = curr.getChildren();
        for (int i = 0; i < prefix.length(); i++) {
            if (childs.containsKey(prefix.charAt(i))) {
                childs = childs.get(prefix.charAt(i)).getChildren();
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("loving");
        trie.insert("loved");
        trie.insert("love");
        trie.insert("pain");
        System.out.println(trie.search("loving"));
        System.out.println(trie.startsWith("lov"));
        System.out.println(trie.startsWith("lover"));
        System.out.println(trie.root.getChildren().toString());
    }
}
