package Recursions;

public class ReversePrintString {

    public void reversePrintString(String s) {
        reversePrintStringHelper(s, s.length() - 1);
    }

    private void reversePrintStringHelper(String s, int index) {
        if (index < 0) {
            return;
        }
        System.out.println(s.charAt(index));
        reversePrintStringHelper(s, index - 1);
    }

    public static void main(String[] args) {
        ReversePrintString obj = new ReversePrintString();
        String str = "abcdefghijklmnopqrstuvwxyz";
        obj.reversePrintString(str);
    }

}
