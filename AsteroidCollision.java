import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        // Now time to push/pop from stack
        for (int i = 0; i < asteroids.length; i++) {
            int currAsteroid = asteroids[i];
            if (currAsteroid > 0) {
                // if positive encountered,simply push
                st.push(currAsteroid);
                continue;
            }
            // Now this needs to be handled
            if (currAsteroid < 0) {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(currAsteroid)) {
                    // pop till small can be brusted
                    st.pop();
                }
                if (!st.isEmpty() && st.peek() == Math.abs(currAsteroid)) {
                    // pop that and continue
                    st.pop();
                    continue;
                }
                // If became empty or negative one found,just push
                if (st.isEmpty() || (!st.isEmpty() && st.peek() < 0)) {
                    st.add(currAsteroid);
                }
            }
        }
        int[] ans = new int[st.size()];
        int idx = st.size() - 1;
        while (!st.isEmpty()) {
            ans[idx] = st.pop();
            idx -= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        AsteroidCollision obj = new AsteroidCollision();
        int[] asteroids = { 5, 10, -5 };
        int[] ans = obj.asteroidCollision(asteroids);
        System.out.println(Arrays.toString(ans));
    }
}
