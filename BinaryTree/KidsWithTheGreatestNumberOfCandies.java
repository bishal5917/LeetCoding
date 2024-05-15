package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        // Lets find the maxOneFirst
        int maxCandy = Integer.MIN_VALUE;
        for (int candy : candies) {
            maxCandy = Math.max(maxCandy, candy);
        }
        System.out.println(maxCandy);
        for (int candy : candies) {
            int candiesAfterAddition = candy + extraCandies;
            if (candiesAfterAddition >= maxCandy) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        KidsWithTheGreatestNumberOfCandies obj = new KidsWithTheGreatestNumberOfCandies();
        int[] candies = { 2, 3, 5, 1, 3 };
        int extraCandies = 3;
        System.out.println(obj.kidsWithCandies(candies, extraCandies));
    }
}
