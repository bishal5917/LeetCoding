import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountItemsMatchingRule {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for (List<String> item : items) {
            if ((ruleKey.equals("type") && ruleValue.equals(item.get(0))) ||
                    (ruleKey.equals("color") && ruleValue.equals(item.get(1))) ||
                    (ruleKey.equals("name") && ruleValue.equals(item.get(2)))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountItemsMatchingRule obj = new CountItemsMatchingRule();
        String ruleKey = "color";
        String ruleValue = "silver";
        List<List<String>> items = new ArrayList<>();
        items.add(Arrays.asList("phone", "blue", "pixel"));
        items.add(Arrays.asList("computer", "silver", "lenovo"));
        items.add(Arrays.asList("phone", "gold", "iphone"));
        System.out.println(obj.countMatches(items, ruleKey, ruleValue));
    }
}
