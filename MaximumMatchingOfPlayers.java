import java.util.Arrays;

public class MaximumMatchingOfPlayers {

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int matches = 0;
        int p = 0;
        int t = 0;
        Arrays.sort(players);
        Arrays.sort(trainers);
        while (p < players.length && t < trainers.length) {
            if (players[p] <= trainers[t]) {
                p += 1;
                t += 1;
                matches += 1;
            } else {
                t += 1;
            }
        }
        return matches;
    }

    public static void main(String[] args) {
        MaximumMatchingOfPlayers obj = new MaximumMatchingOfPlayers();
        int[] players = { 4, 7, 9 };
        int[] trainers = { 8, 2, 5, 8 };
        System.out.println(obj.matchPlayersAndTrainers(players, trainers));
    }
}
