import java.util.HashMap;
import java.util.Stack;

public class FreqStack {

    HashMap<Integer, Integer> count;
    HashMap<Integer, Stack<Integer>> map;
    int maxFreq;

    public FreqStack() {
        this.count = new HashMap<>();
        this.map = new HashMap<>();
        this.maxFreq = 0;
    }

    public void push(int val) {
        // lets count
        if (count.containsKey(val)) {
            count.put(val, count.get(val) + 1);
        } else {
            count.put(val, 1);
        }
        int f = count.get(val);
        maxFreq = Math.max(maxFreq, f);
        // Now add to the map
        map.putIfAbsent(f, new Stack<>());
        map.get(f).push(val);
    }

    public int pop() {
        // Now from the maxFreq,pop that
        int val = map.get(maxFreq).pop();
        // now if there are no others left on maxFreq stack,decrease the maxFreq val
        if (map.get(maxFreq).isEmpty()) {
            maxFreq -= 1;
        }
        // decrease the count of the popped element
        count.put(val, count.get(val) - 1);
        return val;
    }

    public static void main(String[] args) {
        FreqStack obj = new FreqStack();
        obj.push(5);
        obj.push(7);
        obj.push(5);
        obj.push(7);
        obj.push(4);
        obj.push(5);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
    }
}