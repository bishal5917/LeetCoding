import java.util.ArrayList;
import java.util.List;

class CustomStack {

    List<Integer> st;
    int maxSize;

    public CustomStack(int maxSize) {
        this.st = new ArrayList<>();
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if (st.size() == maxSize) {
            return;
        }
        st.add(x);
    }

    public int pop() {
        if (st.size() == 0) {
            return -1;
        }
        return st.remove(st.size() - 1);
    }

    public void increment(int k, int val) {
        // Iterate from the last and increment values
        if (st.isEmpty()) {
            return;
        }
        for (int i = 0; i < k; i++) {
            if (i >= 0 && i < st.size()) {
                st.set(i, st.get(i) + val);
            }
        }
    }

    public static void main(String[] args) {
        CustomStack st = new CustomStack(10);
        st.push(10);
        st.push(7);
        st.push(9);
        st.push(6);
        st.increment(2, 1);
        System.out.println(st.st);
    }
}
