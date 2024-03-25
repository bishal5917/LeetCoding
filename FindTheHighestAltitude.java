public class FindTheHighestAltitude {

    public int largestAltitude(int[] gain) {
        int highest = 0;
        for (int i = 1; i < gain.length; i++) {
            gain[i] = gain[i - 1] + gain[i];
        }
        // Now find the highest
        for (int i = 0; i < gain.length; i++) {
            highest = Math.max(highest, gain[i]);
        }
        return highest;
    }

    public static void main(String[] args) {
        FindTheHighestAltitude obj = new FindTheHighestAltitude();
        int[] gain = { -5, 1, 5, 0, -7 };
        System.out.println(obj.largestAltitude(gain));
    }
}
