import java.util.ArrayList;
import java.util.List;

public class FindUniqueBinaryString {

    public String findDifferentBinaryString(String[] nums) {
        // ************************************** Less Optimal Solution Totally
        // Bruteforced

        // Totally bruteforced solution (Generate all binary strings and store them and
        // check one by
        // one)
        List<String> allNums = new ArrayList<>();
        List<String> first = generateAllPossibleBinaryStrings(new StringBuilder("0"),
                nums[0].length(),
                new ArrayList<>());
        List<String> second = generateAllPossibleBinaryStrings(new StringBuilder("1"), nums[0].length(),
                new ArrayList<>());
        allNums.addAll(first);
        allNums.addAll(second);
        System.out.println(allNums);
        for (String bString : nums) {
            allNums.remove(bString);
        }
        // System.out.println(allNums);
        // return allNums.get(0);
        // ************************************** MORE OPTIMAL SOLUTION
        List<String> given = new ArrayList<>();
        for (String bStrings : nums) {
            given.add(bStrings);
        }
        String firstUnique = findUniqueStringRecursiveHelper(new StringBuilder("0"), nums[0].length(), given, "");
        if (firstUnique.isEmpty()) {
            return findUniqueStringRecursiveHelper(new StringBuilder("1"), nums[0].length(), given, "");
        } else {
            return firstUnique;
        }
    }

    public List<String> generateAllPossibleBinaryStrings(StringBuilder currStr, int len, List<String> allStrings) {
        if (currStr.length() == len) {
            allStrings.add(currStr.toString());
            return allStrings;
        }
        currStr.append("1");
        generateAllPossibleBinaryStrings(currStr, len, allStrings);
        currStr.deleteCharAt(currStr.length() - 1);
        currStr.append("0");
        generateAllPossibleBinaryStrings(currStr, len, allStrings);
        currStr.deleteCharAt(currStr.length() - 1);
        return allStrings;
    }

    // More optimal solution
    public String findUniqueStringRecursiveHelper(StringBuilder currStr, int len, List<String> nums, String unique) {
        if (currStr.length() == len) {
            if (!nums.contains(currStr.toString())) {
                unique = currStr.toString();
            }
            return unique;
        }
        currStr.append("1");
        unique = findUniqueStringRecursiveHelper(currStr, len, nums, unique);
        currStr.deleteCharAt(currStr.length() - 1);
        currStr.append("0");
        unique = findUniqueStringRecursiveHelper(currStr, len, nums, unique);
        currStr.deleteCharAt(currStr.length() - 1);
        return unique;
    }

    public static void main(String[] args) {
        FindUniqueBinaryString obj = new FindUniqueBinaryString();
        String[] nums = { "111", "011", "001" };
        String ans = obj.findDifferentBinaryString(nums);
        System.out.println(ans);
    }

}
