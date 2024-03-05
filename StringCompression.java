import java.util.Arrays;

public class StringCompression {

    public int compress(char[] chars) {
        // I had used stringbuilder just for walkthrough at first
        // StringBuilder str = new StringBuilder();
        // Lets keep counting and traversing
        if (chars.length == 1) {
            return 1;
        }
        int i = 0;
        int j = 1;
        int idx = 0;
        while (i < chars.length && j < chars.length) {
            int count = 1;
            if (chars[i] == chars[j]) {
                chars[idx++] = chars[i];
                // str.append(chars[i]);
                while (i < chars.length && j < chars.length && chars[i] == chars[j]) {
                    i += 1;
                    j += 1;
                    count += 1;
                }
                i += 1;
                j += 1;
                // Now put the count to the index at last
                String countVal = String.valueOf(count);
                for (int s = 0; s < countVal.length(); s++) {
                    chars[idx++] = countVal.charAt(s);
                }
                // str.append(Integer.toString(count));
            } else {
                chars[idx++] = chars[i];
                // str.append(chars[i]);
                i += 1;
                j += 1;
            }
        }
        // add the last remaining j if it wasnot equal to the previous one
        if (j - 1 >= 0 && j - 1 < chars.length) {
            chars[idx++] = chars[j - 1];
        }
        System.out.println(Arrays.toString(chars));
        return idx;
    }

    public static void main(String[] args) {
        StringCompression obj = new StringCompression();
        char[] chars = { 'o', 'o', 'd', 'd', 'b', 'b', 'b', 'w', 'o', 'm' };
        System.out.println(obj.compress(chars));
    }
}
