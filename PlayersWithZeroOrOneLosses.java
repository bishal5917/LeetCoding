import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayersWithZeroOrOneLosses {

    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> winners = new ArrayList<>();
        List<Integer> zeroLossesList = new ArrayList<>();
        List<Integer> oneLossesList = new ArrayList<>();
        HashMap<Integer, Integer> lossesCount = new HashMap<>();

        for (int[] match : matches) {
            int wonTeam = match[0];
            int lostTeam = match[1];
            if (lossesCount.get(wonTeam) == null) {
                // We dont care about how many time it has won,we only deal with number of
                // losses
                lossesCount.put(wonTeam, 0);
            }
            if (lossesCount.get(lostTeam) == null || lossesCount.get(lostTeam) == 0) {
                lossesCount.put(lostTeam, 1);
            } else {
                int lossedCount = lossesCount.get(lostTeam);
                lossesCount.put(lostTeam, lossedCount + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : lossesCount.entrySet()) {
            if (lossesCount.get(entry.getKey()) == 0) {
                zeroLossesList.add(entry.getKey());
            }
            if (lossesCount.get(entry.getKey()) == 1) {
                oneLossesList.add(entry.getKey());
            }
        }
        Collections.sort(zeroLossesList);
        Collections.sort(oneLossesList);
        winners.add(zeroLossesList);
        winners.add(oneLossesList);
        return winners;
    }

    public static void main(String[] args) {
        PlayersWithZeroOrOneLosses obj = new PlayersWithZeroOrOneLosses();
        int[][] nums = { { 1, 3 }, { 2, 3 }, { 3, 6 }, { 5, 6 }, { 5, 7 }, { 4, 5 }, { 4, 8 }, { 4, 9 }, { 10, 4 },
                { 10, 9 } };
        System.out.println(obj.findWinners(nums));
    }

}
