import java.util.Stack;

public class ClumsyFactorial {

    public int clumsy(int n) {
        // lets keep adding to the stack
        Stack<String> st = new Stack<>();
        String[] symbols = { "M", "D", "A", "S" };
        int symbolIdx = 0;
        // Keep iterating and adding index
        for (int i = n; i >= 1; i--) {
            st.push(Integer.toString(i));
            st.push(symbols[symbolIdx]);
            symbolIdx += 1;
            if (symbolIdx == 4) {
                symbolIdx = 0;
            }
        }
        // pop the last symbol from the stack
        st.pop();
        // Now process the stack and keep storing calculated values
        Stack<String> auxSt = new Stack<>();
        // Push from back in new stack coz we gotta process from first
        for (int i = st.size() - 1; i >= 0; i--) {
            auxSt.push(st.get(i));
        }
        System.out.println(st);
        System.out.println(auxSt);
        // This doesnot work,gotta use the BODMAS Rule
        while (auxSt.size() > 1) {
            int valueFirst = Integer.valueOf(auxSt.pop());
            String symbol = auxSt.pop();
            int valueSecond = Integer.valueOf(auxSt.pop());
            // Now check what to do
            int calculated = 1;
            if (symbol.equals("M")) {
                calculated = valueFirst * valueSecond;
            } else if (symbol.equals("D")) {
                calculated = valueFirst / valueSecond;
            } else if (symbol.equals("A")) {
                calculated = valueFirst + valueSecond;
            } else if (symbol.equals("S")) {
                calculated = valueFirst - valueSecond;
            }
            auxSt.push(String.valueOf(calculated));
            System.out.println(auxSt);
        }
        System.out.println(auxSt);
        return Integer.valueOf(auxSt.get(0));
    }

    public static void main(String[] args) {
        ClumsyFactorial obj = new ClumsyFactorial();
        System.out.println(obj.clumsy(10));
    }

}
