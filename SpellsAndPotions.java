import java.util.Arrays;

public class SpellsAndPotions {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] pairs = new int[spells.length];
        // we binary search the value for each spells
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int count = binarySearch(potions, spells[i], success);
            pairs[i] = count;
        }
        return pairs;
    }

    private int binarySearch(int[] potions, int spell, long target) {
        long l = 0;
        long r = potions.length - 1;
        while (l <= r) {
            int mid = (int) (l + (r - l) / 2);
            long paired = (long) spell * (long) potions[mid];
            if (paired >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) (potions.length - l);
    }

    public static void main(String[] args) {
        SpellsAndPotions obj = new SpellsAndPotions();
        int[] spells = { 5, 1, 3 };
        int[] potions = { 1, 2, 3, 4, 5 };
        long success = 7;
        int[] ans = obj.successfulPairs(spells, potions, success);
        System.out.println(Arrays.toString(ans));
    }
}
