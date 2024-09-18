import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

class ReplaceWordTrie {

    private TrieNode root;

    public TrieNode getRoot() {
        return root;
    }

    public ReplaceWordTrie() {
        // instantiate a root node
        root = new TrieNode(new HashMap<>(), false);
    }

    // PREFIX TREE
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

    public String search(String word) {
        StringBuilder found = new StringBuilder();
        TrieNode curr;
        curr = root;
        boolean wasEndFound = false;
        HashMap<Character, TrieNode> childs = curr.getChildren();
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (childs.containsKey(currChar)) {
                found.append(currChar);
                if (childs.get(currChar).isEndOfTheWord() == true) {
                    // means last of the deal found, break out
                    wasEndFound = true;
                    break;
                }
                childs = childs.get(currChar).getChildren();
            } else {
                break;
            }
        }
        return wasEndFound ? found.toString() : word;
    }
}

public class ReplaceWords {

    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder str = new StringBuilder();
        // Lets put these dict words to the trie
        ReplaceWordTrie obj = new ReplaceWordTrie();
        for (String word : dictionary) {
            obj.insert(word);
        }
        // Now we search and replace those
        String[] sents = sentence.split(" ");
        for (int i = 0; i < sents.length; i++) {
            String word = sents[i];
            str.append(obj.search(word));
            if (i != sents.length - 1) {
                str.append(" ");
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        ReplaceWords obj = new ReplaceWords();
        List<String> dictionary = new ArrayList<>(
                Arrays.asList("cat", "rat", "bat"));
        String sentence = "the cattle was rattled by the battery";
        System.out.println(obj.replaceWords(dictionary, sentence));
    }
}
