public class StringWithoutAAABBB {

    public String strWithout3a3b(int a, int b) {
        StringBuilder str = new StringBuilder();
        // Lets use the greedy approach
        boolean isATurn = a > b;
        while (a + b > 0) {
            if (isATurn && a > 0) {
                if (a > b) {
                    int times = Math.min(2, a);
                    while (times > 0) {
                        str.append('a');
                        a -= 1;
                        times -= 1;
                    }
                } else {
                    int times = Math.min(1, a);
                    while (times > 0) {
                        str.append('a');
                        a -= 1;
                        times -= 1;
                    }
                }
                isATurn = false;
            } else if (!isATurn && b > 0) {
                if (b > a) {
                    int times = Math.min(2, b);
                    while (times > 0) {
                        str.append('b');
                        b -= 1;
                        times -= 1;
                    }
                } else {
                    int times = Math.min(1, b);
                    while (times > 0) {
                        str.append('b');
                        b -= 1;
                        times -= 1;
                    }
                }
                isATurn = true;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringWithoutAAABBB obj = new StringWithoutAAABBB();
        int a = 2;
        int b = 5;
        System.out.println(obj.strWithout3a3b(a, b));
    }
}