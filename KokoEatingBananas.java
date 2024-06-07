import java.util.Arrays;

public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int k = piles[piles.length - 1];
        // we do binary search on k
        // The max k gonna be max of piles
        // we do binary search on l=1 to r=k
        int l = 1;
        int r = k;
        while (l <= r) {
            int mid = (l + (r - l) / 2);
            // now we check if koko could eat all within hours
            if (couldEat(piles, mid, h)) {
                // then we try to find even lesser,go left
                k = Math.min(k, mid);
                r = mid - 1;
            } else {
                // else we are obliged to look for greater val
                l = mid + 1;
            }
        }
        return k;
    }

    private boolean couldEat(int[] piles, int k, int h) {
        int hours = 0;
        for (int pile : piles) {
            double val = (double) pile / k;
            hours += Math.ceil(val);
        }
        return hours <= h;
    }

    public static void main(String[] args) {
        KokoEatingBananas obj = new KokoEatingBananas();
        int[] piles = { 3, 6, 7, 11 };
        int h = 8;
        System.out.println(obj.minEatingSpeed(piles, h));
    }
}
