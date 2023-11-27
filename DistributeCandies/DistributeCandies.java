package DistributeCandies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DistributeCandies {

    public int distributeCandies(int[] candyType) {
        List<Integer> uniques = new ArrayList<>();
        for (int candy : candyType) {
            if (isCandyPresent(uniques, candy) == false) {
                uniques.add(candy);
            }
        }
        System.out.println(Math.min(candyType.length / 2, uniques.size()));
        return Math.min(candyType.length / 2, uniques.size());
    }

    public Boolean isCandyPresent(List<Integer> candies, int candy) {
        Collections.sort(candies);
        int l = 0;
        int r = candies.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (candies.get(mid) == candy) {
                return true;
            } else if (candy < candies.get(mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
        // for (int item : candies) {
        // if (item == candy) {
        // return true;
        // }
        // }
        // return false;
    }

    public static void main(String[] args) {
        int[] candyType = { 6, 6, 6, 6 };
        DistributeCandies obj = new DistributeCandies();
        obj.distributeCandies(candyType);
    }
}
