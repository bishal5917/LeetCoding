import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EvaluateBracketPairsOfString {

    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> knowledgeMap = new HashMap<>();
        // puuting knowledge in our knowledgeMap
        for (List<String> item : knowledge) {
            knowledgeMap.put(item.get(0), item.get(1));
        }
        // Now process the array
        StringBuilder ans = new StringBuilder();
        int idx = 0;
        while (idx < s.length()) {
            if (s.charAt(idx) == '(') {
                idx += 1;
                StringBuilder placeValue = new StringBuilder();
                while (s.charAt(idx) != ')') {
                    placeValue.append(s.charAt(idx));
                    idx = idx + 1;
                }
                String val = knowledgeMap.get(placeValue.toString());
                if (val != null) {
                    ans.append(knowledgeMap.get(placeValue.toString()));
                } else {
                    // If not found just append ?
                    ans.append('?');
                }
                // System.out.println(placeValue);
            } else {
                ans.append(s.charAt(idx));
            }
            idx = idx + 1;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        EvaluateBracketPairsOfString obj = new EvaluateBracketPairsOfString();
        String s = "(name)is(age)yearsold";
        List<List<String>> knowledge = new ArrayList<>();
        List<String> knowledge1 = new ArrayList<>();
        knowledge1.add("name");
        knowledge1.add("Bsal");
        knowledge.add(knowledge1);
        List<String> knowledge2 = new ArrayList<>();
        knowledge2.add("age");
        knowledge2.add("23");
        knowledge.add(knowledge2);
        System.out.println(obj.evaluate(s, knowledge));
    }

}
