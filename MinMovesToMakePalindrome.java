public class MinMovesToMakePalindrome {

    public int minMovesToMakePalindrome(String s) {
        int n = s.length();
        int moves = 0;
        char[] str = s.toCharArray();
        // We use the two pointers
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            if (str[l] == str[r]) {
                // if same do nothing just go
                l += 1;
                r -= 1;
            } else {
                // else we start at k=r and go back till we find the character at the left
                int k = goBackToFindLeftChar(l, r, str);
                if (k == -1) {
                    // we swap l and l+1 and do this continue
                    boolean swapped = swap(l, l + 1, str);
                    if (swapped) {
                        moves += 1;
                    }
                } else {
                    // else we move k till the right and swap along the way
                    while (k < r) {
                        boolean swapped = swap(k, k + 1, str);
                        if (swapped) {
                            moves += 1;
                        }
                        k += 1;
                    }
                    l += 1;
                    r -= 1;
                }
            }
        }
        return moves;
    }

    // go back and find same character
    private int goBackToFindLeftChar(int l, int k, char[] str) {
        while (k > l) {
            if (str[l] == str[k]) {
                return k;
            }
            k -= 1;
        }
        return -1;
    }

    // making swap utility function
    private boolean swap(int a, int b, char[] str) {
        if (a >= str.length || b >= str.length) {
            return false;
        }
        char temp = str[a];
        str[a] = str[b];
        str[b] = temp;
        return true;
    }

    public static void main(String[] args) {
        MinMovesToMakePalindrome obj = new MinMovesToMakePalindrome();
        String s = "aabb";
        System.out.println(obj.minMovesToMakePalindrome(s));
    }
}
