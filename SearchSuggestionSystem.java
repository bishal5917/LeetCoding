import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionSystem {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> prods = new ArrayList<>();
        // Lets one by one character check
        int l = 0;
        int r = products.length - 1;
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> prod = new ArrayList<>();
            while (l <= r
                    && (i >= products[l].length() || products[l].charAt(i) != searchWord.charAt(i))) {
                l++;
            }

            while (l <= r
                    && (i >= products[r].length() || products[r].charAt(i) != searchWord.charAt(i))) {
                r--;
            }
            for (int idx = l; idx <= l + 2; idx++) {
                if (idx >= products.length || idx > r) {
                    break;
                }
                prod.add(products[idx]);
            }
            prods.add(prod);
        }
        return prods;
    }

    public static void main(String[] args) {
        SearchSuggestionSystem obj = new SearchSuggestionSystem();
        String[] products = { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
        String searchWord = "mouse";
        System.out.println(obj.suggestedProducts(products, searchWord));
    }
}