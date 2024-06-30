import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {

    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> visits = new ArrayList<>();
        HashMap<String, Integer> visited = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            String domain = cpdomains[i];
            String[] splitted = domain.split(" ");
            String count = splitted[0];
            String subdomain = splitted[1];
            if (visited.containsKey(subdomain)) {
                visited.put(subdomain, Integer.valueOf(count) + visited.get(subdomain));
            } else {
                visited.put(subdomain, Integer.valueOf(count));
            }
            // Now we go till we find comma
            for (int idx = 0; idx < subdomain.length(); idx++) {
                if (subdomain.charAt(idx) == '.') {
                    String curr = subdomain.substring(idx + 1, subdomain.length());
                    // Now gotta check if its already visited
                    int totalCount = Integer.valueOf(count);
                    if (visited.containsKey(curr)) {
                        // get the count
                        totalCount += visited.get(curr);
                        // update
                        visited.put(curr, totalCount);
                    } else {
                        visited.put(curr, totalCount);
                    }
                }
            }
        }
        System.out.println(visited);
        // Now iterate over the map and put in visits
        for (Map.Entry<String, Integer> entry : visited.entrySet()) {
            StringBuilder subDomain = new StringBuilder();
            subDomain.append(entry.getValue());
            subDomain.append(" ");
            subDomain.append(entry.getKey());
            visits.add(subDomain.toString());
        }
        return visits;
    }

    public static void main(String[] args) {
        SubdomainVisitCount obj = new SubdomainVisitCount();
        String[] cpdomains = { "9001 discuss.leetcode.com" };
        System.out.println(obj.subdomainVisits(cpdomains));
    }
}
