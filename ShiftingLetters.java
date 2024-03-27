import java.util.Arrays;

public class ShiftingLetters {

    public String shiftingLetters(String s, int[] shifts) {
        // Lets find the prefix sum for how many shifts should be done
        StringBuilder str = new StringBuilder();
        // Finding the prefix sum
        int n = shifts.length;
        for (int i = shifts.length - 2; i >= 0; i--)
            shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
        // Now lets calculate the shift
        for (int i = 0; i < n; i++) {
            // find the shifts
            int shift = shifts[i];
            int currAscii = s.charAt(i);
            int res = ('a' + (currAscii - 'a' + shift) % 26);
            str.append((char) res);
        }
        System.out.println(Arrays.toString(shifts));
        return str.toString();
    }

    public static void main(String[] args) {
        ShiftingLetters obj = new ShiftingLetters();
        String s = "abc";
        int[] shifts = { 3, 5, 9 };
        System.out.println(obj.shiftingLetters(s, shifts));
    }
}
