import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileInSystem {

    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for (String path : paths) {
            // Lets split by space first
            String[] files = path.split(" ");
            // we go through each one of them and get the names and we put
            for (int i = 1; i < files.length; i++) {
                StringBuilder location = new StringBuilder(files[0]);
                String curr = files[i];
                // we gotta get the content of the file
                int idx = 0;
                while (idx < curr.length()) {
                    if (curr.charAt(idx) == '(') {
                        break;
                    }
                    idx++;
                }
                String fileName = curr.substring(0, idx);
                String fileContent = curr.substring(idx + 1, curr.length() - 1);
                location.append("/");
                location.append(fileName);
                // Now time to add to a hashmap
                map.putIfAbsent(fileContent, new ArrayList<>());
                map.get(fileContent).add(location.toString());
                // System.out.println(location + "&&" + fileName + "&&" + fileContent);
            }
        }
        // System.out.println(map);
        // Now we iterate over the Map and add to ans
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                // Thats because we only want the duplicates
                ans.add(entry.getValue());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindDuplicateFileInSystem obj = new FindDuplicateFileInSystem();
        String[] paths = {
                "root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"
        };
        System.out.println(obj.findDuplicate(paths));
    }
}
