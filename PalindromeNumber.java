
class PalindromeNumber {
    public boolean isPalindrome(int x) {

        String newX = Integer.toString(x);
        int i = 0;
        int j = newX.length() - 1;

        while (i != j & i < newX.length() & j >= 0) {
            if (newX.charAt(i) == newX.charAt(j)) {
                i += 1;
                j -= 1;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber pd = new PalindromeNumber();
        System.out.println(pd.isPalindrome(11));
    }
}