import java.util.HashSet;

public class SimilarStringGroups {

    public int numSimilarGroups(String[] strs) {
        int group = 0;
        HashSet<String> visited = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if (visited.contains(str)) {
                continue;
            }
            group += 1;
            dfsHelper(strs, visited, i);
        }
        return group;
    }

    private void dfsHelper(String[] strs, HashSet<String> visited, int idx) {
        visited.add(strs[idx]);
        // gotta run DFS now
        for (int i = 0; i < strs.length; i++) {
            if (visited.contains(strs[i])) {
                continue;
            }
            if (areSimilar(strs[i], strs[idx])) {
                dfsHelper(strs, visited, i);
            }
        }
    }

    private boolean areSimilar(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count += 1;
            }
            if (count > 2) {
                return false;
            }
        }
        return count <= 2;
    }

    public static void main(String[] args) {
        SimilarStringGroups obj = new SimilarStringGroups();
        String[] strs = { "tars", "rats", "arts", "star" };
        System.out.println(obj.numSimilarGroups(strs));
    }
}
