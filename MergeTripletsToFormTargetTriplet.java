
public class MergeTripletsToFormTargetTriplet {

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] ans = new int[3];
        for (int[] triplet : triplets) {
            if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                ans[0] = Math.max(ans[0], triplet[0]);
                ans[1] = Math.max(ans[1], triplet[1]);
                ans[2] = Math.max(ans[2], triplet[2]);
            }
        }
        for (int i = 0; i < 3; i++) {
            if (ans[i] != target[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MergeTripletsToFormTargetTriplet obj = new MergeTripletsToFormTargetTriplet();
        int[][] triplets = {
                { 2, 5, 3 }, { 1, 8, 4 }, { 1, 7, 5 }
        };
        int[] target = { 2, 7, 5 };
        System.out.println(obj.mergeTriplets(triplets, target));
    }
}
