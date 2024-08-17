import java.util.ArrayList;
import java.util.List;

public class FilterRestaurants {

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> rests = new ArrayList<>();
        List<int[]> filtered = new ArrayList<>();
        for (int[] restaurant : restaurants) {
            boolean isVeganMatch = veganFriendly == 0 || restaurant[2] == veganFriendly;
            boolean isPriceMatch = restaurant[3] <= maxPrice;
            boolean isDistanceMatch = restaurant[4] <= maxDistance;

            if (isVeganMatch && isPriceMatch && isDistanceMatch) {
                // Filter successful, add id and rating
                filtered.add(new int[] { restaurant[0], restaurant[1] });
            }
        }
        // now we sort the filtered based on rating and if ratings same sort by id
        filtered.sort((a, b) -> {
            int ratingComparison = Integer.compare(b[1], a[1]); // Compare by rating (descending order)
            if (ratingComparison != 0) {
                return ratingComparison;
            }
            return Integer.compare(b[0], a[0]); // If ratings are the same, compare by id (ascending order)
        });
        for (int[] val : filtered) {
            rests.add(val[0]);
        }
        return rests;
    }

    public static void main(String[] args) {
        FilterRestaurants obj = new FilterRestaurants();
        int[][] restaurants = {
                { 1, 4, 1, 40, 10 },
                { 2, 8, 0, 50, 5 },
                { 3, 8, 1, 30, 4 },
                { 4, 10, 0, 10, 3 },
                { 5, 1, 1, 15, 1 } };
        int veganFriendly = 1;
        int maxPrice = 50;
        int maxDistance = 10;
        System.out.println(obj.filterRestaurants(restaurants, veganFriendly, maxPrice, maxDistance));
    }
}
