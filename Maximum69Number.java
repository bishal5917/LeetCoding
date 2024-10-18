public class Maximum69Number {

    public int maximum69Number(int num) {
        StringBuilder sbr = new StringBuilder(String.valueOf(num));
        for (int i = 0; i < sbr.length(); i++) {
            // Replace the first 6 with 9 and that will be the largest
            if (sbr.charAt(i) == '6') {
                sbr.setCharAt(i, '9');
                break;
            }
        }
        return Integer.valueOf(sbr.toString());
    }

    public static void main(String[] args) {
        Maximum69Number obj = new Maximum69Number();
        int num = 9669;
        System.out.println(obj.maximum69Number(num));
    }
}
