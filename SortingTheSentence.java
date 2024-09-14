import java.util.HashMap;

public class SortingTheSentence {

    public String sortSentence(String s) {
        StringBuilder ans = new StringBuilder();
        HashMap<Integer, String> map = new HashMap<>();
        String[] str = s.split(" ");
        // Now we store digit as key and the index as value
        for (String word : str) {
            StringBuilder wstr = new StringBuilder();
            int position = -1;
            for (char c : word.toCharArray()) {
                if (Character.isAlphabetic(c)) {
                    wstr.append(c);
                } else {
                    position = Integer.valueOf(String.valueOf(c));
                }
            }
            // Now we add to the map
            map.put(position, wstr.toString());
        }
        for (int i = 1; i <= 9; i++) {
            if (map.get(i) == null) {
                break;
            }
            ans.append(map.get(i));
            if (i < str.length) {
                ans.append(" ");
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        SortingTheSentence obj = new SortingTheSentence();
        String s = "is2 sentence4 This1 a3";
        System.out.println(obj.sortSentence(s));
    }
}
