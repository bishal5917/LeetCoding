
public class LetterTilePossibilities {

    public int numTilePossibilities(String tiles) {
        int[] counts = new int[26];
        for (char c : tiles.toCharArray()) {
            counts[c - 'A'] += 1;
        }
        return letterTileHelper(counts, 0);
    }

    private int letterTileHelper(int[] counts, int sum) {
        for (int i = 0; i < 26; i++) {
            if (counts[i] == 0) {
                continue;
            }
            sum += 1;
            counts[i] -= 1;
            sum = letterTileHelper(counts, sum);
            counts[i] += 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        LetterTilePossibilities obj = new LetterTilePossibilities();
        String tiles = "AAB";
        System.out.println(obj.numTilePossibilities(tiles));
    }
}
