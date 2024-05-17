package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ThroneInheritance {

    String king = null;
    HashMap<String, List<String>> fam;
    HashSet<String> dead;

    public ThroneInheritance(String kingName) {
        this.king = kingName;
        this.fam = new HashMap<>();
        this.dead = new HashSet<>();
    }

    public void birth(String parentName, String childName) {
        this.fam.putIfAbsent(parentName, new ArrayList<>());
        this.fam.get(parentName).add(childName);
    }

    public void death(String name) {
        this.dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        // This is just a preorder traversal
        // Gotta unconsider the dead
        return dfsHelper(king, new ArrayList<>());
    }

    private List<String> dfsHelper(String root, List<String> order) {
        if (root == null) {
            return order;
        }
        // add the current if its not dead
        if (!this.dead.contains(root)) {
            order.add(root);
        }
        // Go for all children in DFS
        if (this.fam.get(root) != null) {
            for (String child : this.fam.get(root)) {
                order = dfsHelper(child, order);
            }
        }
        return order;
    }

    public static void main(String[] args) {
        ThroneInheritance obj = new ThroneInheritance("King");
        obj.birth("King", "Alice");
        obj.birth("King", "Bob");
        obj.birth("Alice", "Jack");
        System.out.println(obj.getInheritanceOrder());
    }
}
