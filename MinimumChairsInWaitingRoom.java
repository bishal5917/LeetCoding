public class MinimumChairsInWaitingRoom {

    public int minimumChairs(String s) {
        int maxWaiting = 0;
        int currWaiting = 0;
        for (char c : s.toCharArray()) {
            if (c == 'E') {
                currWaiting++;
            } else {
                currWaiting--;
            }
            maxWaiting = Math.max(maxWaiting, currWaiting);
        }
        return maxWaiting;
    }

    public static void main(String[] args) {
        MinimumChairsInWaitingRoom obj = new MinimumChairsInWaitingRoom();
        String s = "ELELEEL";
        System.out.println(obj.minimumChairs(s));
    }
}
