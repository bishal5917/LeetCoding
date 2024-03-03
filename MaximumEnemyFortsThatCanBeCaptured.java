public class MaximumEnemyFortsThatCanBeCaptured {

    public int captureForts(int[] forts) {
        int maxForts = 0;
        int firstPortIdx = -1;
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] == 1) {
                firstPortIdx = i;
                break;
            }
        }
        // if there are no self belonging ports return 0;
        if (firstPortIdx == -1)
            return 0;
        int currForts = 0;
        for (int i = firstPortIdx; i < forts.length; i++) {
            if (forts[i] == 0) {
                currForts += 1;
            } else {
                maxForts = Math.max(maxForts, currForts);
                currForts = 0;
            }
        }
        return maxForts;
    }

    public static void main(String[] args) {
        int[] forts = { 1, 0, 0, -1, 0, 0, 0, 0, 1 };
        MaximumEnemyFortsThatCanBeCaptured obj = new MaximumEnemyFortsThatCanBeCaptured();
        System.out.println(obj.captureForts(forts));
    }
}
