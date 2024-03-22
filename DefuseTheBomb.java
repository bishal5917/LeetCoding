import java.util.Arrays;

public class DefuseTheBomb {

    public int[] decrypt(int[] code, int k) {
        int[] decrypted = new int[code.length];
        if (k == 0)
            return decrypted;
        if (code.length <= 1)
            return code;
        int n = code.length;
        int sum = 0;
        // Now lets maintain a window of size k after the 0th index
        if (k > 0) {
            // FOR POSITIVE CONDITION
            int i = 1;
            int j = 1;
            int loop = 0;
            while (loop < k) {
                sum += code[j];
                j = (j + 1) % n;
                loop += 1;
            }
            // Store in original array
            decrypted[i - 1] = sum;
            // NOW LETS SLIDE THE WINDOW
            while (i < code.length) {
                sum -= code[i];
                sum += code[j];
                decrypted[i] = sum;
                i = i + 1;
                j = (j + 1) % n;
            }
        } else {
            // FOR NEGATIVE CONDITION
            int idx = 0;
            int j = n - 1;
            int loop = 0;
            while (loop < Math.abs(k)) {
                sum += code[j];
                j -= 1;
                loop += 1;
            }
            decrypted[idx++] = sum;
            // rearranging back i and j
            int i = n - Math.abs(k);
            j = 0;
            // NOW LETS SLIDE THE WINDOW
            while (idx < code.length) {
                sum -= code[i];
                sum += code[j];
                decrypted[idx++] = sum;
                i = (i + 1) % n;
                j = (j + 1) % n;
            }
        }
        return decrypted;
    }

    public static void main(String[] args) {
        DefuseTheBomb obj = new DefuseTheBomb();
        int[] code = { 2, 4, 9, 3 };
        int k = -2;
        int[] ans = obj.decrypt(code, k);
        System.out.println(Arrays.toString(ans));
    }
}
