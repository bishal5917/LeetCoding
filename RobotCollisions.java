import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class RobotCollisions {

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> robots = new ArrayList<>();
        // create a hashmap for storing pos vs health,pos vs direction
        // and pos vs robot idx
        HashMap<Integer, Integer> hmap = new HashMap<>();
        HashMap<Integer, Integer> posmap = new HashMap<>();
        HashMap<Integer, Character> dmap = new HashMap<>();
        // Now lets put values
        for (int i = 0; i < positions.length; i++) {
            hmap.put(positions[i], healths[i]);
            posmap.put(i + 1, positions[i]);
            dmap.put(positions[i], directions.charAt(i));
        }
        // Using the stack
        Arrays.sort(positions);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < positions.length; i++) {
            int pos = positions[i];
            if (dmap.get(pos) == 'R') {
                // if right just push and continue
                st.push(pos);
                continue;
            }
            // else we go back till the weight is not zero
            while (!st.isEmpty() && hmap.get(pos) > 0) {
                // peek
                int top = st.peek();
                if (hmap.get(top) < hmap.get(pos)) {
                    // remove the top
                    hmap.put(st.pop(), 0);
                    hmap.put(pos, hmap.get(pos) - 1);
                } else if (hmap.get(top) > hmap.get(pos)) {
                    hmap.put(top, hmap.get(top) - 1);
                    hmap.put(pos, 0);
                } else {
                    // if same
                    hmap.put(st.pop(), 0);
                    hmap.put(pos, 0);
                }
            }
        }
        // Now time to append the answer
        for (int i = 0; i < positions.length; i++) {
            // curr pos
            int pos = posmap.get(i + 1);
            if (hmap.get(pos) != 0) {
                robots.add(hmap.get(pos));
            }
        }
        return robots;
    }

    public static void main(String[] args) {
        RobotCollisions obj = new RobotCollisions();
        int[] positions = { 3, 5, 2, 6 };
        int[] healths = { 10, 10, 15, 12 };
        String directions = "RLRL";
        System.out.println(obj.survivedRobotsHealths(positions, healths, directions));
    }
}