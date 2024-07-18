import java.util.Stack;

class StockSpanner {

    Stack<int[]> st;

    public StockSpanner() {
        this.st = new Stack<>();
    }

    public int next(int price) {
        // Now we check the previous,if its lesser or equal we add the value of that one
        // and then we push again
        int span = 1;
        while (!st.isEmpty() && price >= st.peek()[0]) {
            span += st.peek()[1];
            st.pop();
        }
        st.push(new int[] { price, span });
        return span;
    }

    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();
        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(60));
        System.out.println(obj.next(70));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));
        System.out.println(obj.next(85));
    }
}
