public class XOROperationInArray {

    public int xorOperation(int n, int start) {
        int ops = 0;
        int idx = 0;
        // start+2*i;
        while (n > 0) {
            // System.out.println(start + 2 * idx);
            ops ^= (start + 2 * idx);
            idx++;
            n--;
        }
        return ops;
    }

    public static void main(String[] args) {
        XOROperationInArray obj = new XOROperationInArray();
        System.out.println(obj.xorOperation(5, 0));
    }
}
