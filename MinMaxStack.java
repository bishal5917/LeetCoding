//First lets create our stack node

import java.util.ArrayList;
import java.util.List;

class StNode {
    int val;
    int prevMin;
    int prevMax;

    public StNode() {
    }

    public StNode(int val, int prevMin, int prevMax) {
        this.val = val;
        this.prevMin = prevMin;
        this.prevMax = prevMax;
    }
}

class MinMaxStack {

    List<StNode> st;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    public MinMaxStack() {
        this.st = new ArrayList<>();
    }

    public void push(int val) {
        // Lets push the val
        StNode newOne = new StNode();
        newOne.val = val;
        newOne.prevMin = min;
        newOne.prevMax = max;
        min = Math.min(min, val);
        max = Math.max(max, val);
        st.add(newOne);
    }

    public void pop() {
        // get the last one,remove and set new min and max
        StNode lastOne = st.remove(st.size() - 1);
        max = lastOne.prevMax;
        min = lastOne.prevMin;
    }

    public int top() {
        return st.get(st.size() - 1).val;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public static void main(String[] args) {
        MinMaxStack obj = new MinMaxStack();
        obj.push(2);
        obj.push(0);
        obj.push(-1);
        obj.pop();
        System.out.println(obj.getMin());
        System.out.println(obj.getMax());
    }
}
