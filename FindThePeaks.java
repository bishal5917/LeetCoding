import java.util.ArrayList;
import java.util.List;

public class FindThePeaks {

    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> peakIdxs = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            int left = mountain[i - 1];
            int curr = mountain[i];
            int right = mountain[i + 1];
            if (curr > left && curr > right) {
                peakIdxs.add(i);
            }
        }
        return peakIdxs;
    }

    public static void main(String[] args) {
        FindThePeaks obj = new FindThePeaks();
        int[] mountain = { 1, 4, 3, 8, 5 };
        System.out.println(obj.findPeaks(mountain));
    }
}
