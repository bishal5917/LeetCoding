public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= a) {
                a = num;
            } else if (num <= b) {
                b = num;
            } else {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTripletSubsequence obj = new IncreasingTripletSubsequence();
        int[] nums = { 1, 2, 3, 4, 5 };
        System.out.println(obj.increasingTriplet(nums));
    }
}
