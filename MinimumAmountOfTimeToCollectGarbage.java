import java.util.Arrays;

public class MinimumAmountOfTimeToCollectGarbage {

    public int garbageCollection(String[] garbage, int[] travel) {
        int time = 0;
        // Lets store the last containing garbage
        int lastMetalIdx = -1;
        int lastPaperIdx = -1;
        int lastGlassIdx = -1;
        int[][] counts = new int[garbage.length][3];
        for (int i = 0; i < garbage.length; i++) {
            // count metal paper and glass
            int[] garbageQtys = new int[3];
            // Now count
            for (char c : garbage[i].toCharArray()) {
                if (c == 'M') {
                    garbageQtys[0] += 1;
                    lastMetalIdx = i;
                } else if (c == 'P') {
                    garbageQtys[1] += 1;
                    lastPaperIdx = i;
                } else {
                    garbageQtys[2] += 1;
                    lastGlassIdx = i;
                }
            }
            counts[i] = garbageQtys;
        }
        // NOW LETS COLLECT THE GARBAGE TRUCK BY TRUCK
        // FOR METAL TRUCK
        for (int i = 0; i <= lastMetalIdx; i++) {
            time = time + counts[i][0];
            if (i - 1 >= 0) {
                time += travel[i - 1];
            }
        }
        // FOR PAPER TRUCK
        for (int i = 0; i <= lastPaperIdx; i++) {
            time = time + counts[i][1];
            if (i - 1 >= 0) {
                time += travel[i - 1];
            }
        }
        // FOR GLASS TRUCK
        for (int i = 0; i <= lastGlassIdx; i++) {
            time = time + counts[i][2];
            if (i - 1 >= 0) {
                time += travel[i - 1];
            }
        }
        // print the counts
        for (int[] arr : counts) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(lastMetalIdx);
        System.out.println(lastPaperIdx);
        System.out.println(lastGlassIdx);
        return time;
    }

    public static void main(String[] args) {
        MinimumAmountOfTimeToCollectGarbage obj = new MinimumAmountOfTimeToCollectGarbage();
        String[] garbage = { "MMM", "PGM", "GP" };
        int[] travel = { 3, 10 };
        System.out.println(obj.garbageCollection(garbage, travel));
    }
}
