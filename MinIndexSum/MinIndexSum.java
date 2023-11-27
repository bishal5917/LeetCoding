package MinIndexSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinIndexSum {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> ans = new ArrayList<>();
        int currMinSum = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            int idxInList2 = findIndex(list2, list1[i]);
            if (idxInList2 == -1) {
                continue;
            }
            int currSum = Math.abs(i + idxInList2);
            if (currMinSum == currSum) {
                ans.add(list1[i]);
            } else if (currSum < currMinSum) {
                ans.clear();
                ans.add(list1[i]);
                currMinSum = Math.min(currSum, currMinSum);
            }
        }
        String[] resultArray = ans.toArray(new String[0]);
        System.out.println(Arrays.toString(resultArray));
        return resultArray;
    }

    public int findIndex(String[] list, String restaurant) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == restaurant) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] list1 = { "Shogun", "Tapioca Express", "Burger King", "KFC" };
        String[] list2 = { "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun" };
        MinIndexSum obj = new MinIndexSum();
        obj.findRestaurant(list1, list2);
    }
}
