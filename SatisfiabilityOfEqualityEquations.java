//DSU Without Path Compression

import java.util.HashMap;

class DSUForEquation {

    HashMap<Character, Character> parent;
    HashMap<Character, Integer> rank;

    public DSUForEquation() {
        this.parent = new HashMap<>();
        this.rank = new HashMap<>();
        // Fill parent as themselves at beginning
        for (char c = 'a'; c <= 'z'; c++) {
            this.parent.put(c, c);
            this.rank.put(c, 0);
        }
    }

    // Function to find the parent of that node
    public char find(char node) {
        while (this.parent.get(node) != node) {
            node = this.parent.get(node);
        }
        return node;
    }

    // Function to perform union
    // if union is success without forming a cycle,returns true else false
    public boolean union(char x, char y) {
        // find parent
        char xParent = find(x);
        char yParent = find(y);
        if (xParent == yParent) {
            // return false coz if we connect this,it will form a cycle
            return false;
        }
        // check ranks of their parents
        int rankX = this.rank.get(xParent);
        int rankY = this.rank.get(yParent);
        if (rankX > rankY) {
            this.parent.put(yParent, xParent);
        } else if (rankY > rankX) {
            this.parent.put(xParent, yParent);
        } else {
            this.parent.put(xParent, yParent);
            this.rank.put(xParent, this.rank.get(xParent) + 1);
        }
        return true;
    }
}

public class SatisfiabilityOfEqualityEquations {

    public boolean equationsPossible(String[] equations) {
        DSUForEquation dsu = new DSUForEquation();
        // fist perform all merging operations
        for (String eq : equations) {
            char a = eq.charAt(0);
            char b = eq.charAt(3);
            char sign = eq.charAt(1);
            if (sign == '=') {
                dsu.union(a, b);
            }
        }
        // Now check for equality
        for (String eq : equations) {
            char a = eq.charAt(0);
            char b = eq.charAt(3);
            char sign = eq.charAt(1);
            if (sign == '!') {
                if (dsu.find(a) == dsu.find(b)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SatisfiabilityOfEqualityEquations obj = new SatisfiabilityOfEqualityEquations();
        String[] equations = { "a==b", "e==c", "b==c", "a!=e" };
        System.out.println(obj.equationsPossible(equations));
    }

}
