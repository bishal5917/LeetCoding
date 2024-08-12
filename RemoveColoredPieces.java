public class RemoveColoredPieces {

    public boolean winnerOfGame(String colors) {
        int movesForAlice = 0;
        int movesForBob = 0;
        // Lets find total number of moves alice and bob can make
        int n = colors.length();
        int idx = 0;
        while (idx < n) {
            int count = 0;
            char curr = colors.charAt(idx);
            while (idx < n && colors.charAt(idx) == curr) {
                count++;
                idx++;
            }
            if (count >= 3) {
                if (curr == 'A') {
                    movesForAlice += count - 2;
                } else {
                    movesForBob += count - 2;
                }
            }
        }
        System.out.println(" Moves for Alice: " + movesForAlice + " Moves for Bob: " + movesForBob);
        return movesForAlice > movesForBob;
    }

    public static void main(String[] args) {
        RemoveColoredPieces obj = new RemoveColoredPieces();
        String colors = "ABBBBBBBAAA";
        System.out.println(obj.winnerOfGame(colors));
    }
}
