import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LexicallySmallestStringAfterTransformations {

    public String findLexSmallestString(String s, int a, int b) {
        String smallestString = s;
        // We do bfs
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.offer(s);
        while (!q.isEmpty()) {
            String curr = q.poll();
            if (visited.contains(curr)) {
                continue;
            }
            visited.add(curr);
            if (curr.compareTo(smallestString) < 0) {
                smallestString = curr;
            }
            // Now we perform those two operations and add to queue
            q.offer(performAddition(curr, a));
            q.offer(performRotation(curr, b));
        }
        return smallestString;
    }

    private String performAddition(String str, int a) {
        StringBuilder s = new StringBuilder(str);
        for (int i = 1; i < str.length(); i += 2) {
            // we do for every odd idxs
            int val = Integer.valueOf(String.valueOf(str.charAt(i)));
            val += a;
            val = val % 10;
            s.setCharAt(i, (char) (val + '0'));
        }
        return s.toString();
    }

    private String performRotation(String str, int b) {
        String bToEnd = str.substring(b);
        String startTob = str.substring(0, b);
        return bToEnd + startTob;
    }

    public static void main(String[] args) {
        LexicallySmallestStringAfterTransformations obj = new LexicallySmallestStringAfterTransformations();
        String s = "5525";
        int a = 9;
        int b = 2;
        System.out.println(obj.findLexSmallestString(s, a, b));
    }
}
