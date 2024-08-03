public class CountOfMatchesInTournament {

    public int numberOfMatches(int n) {
        int matches = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                // In case of even
                matches += n / 2;
                n = n / 2;
            } else {
                // In case of odd
                matches += (n - 1) / 2;
                n = (n + 1) / 2;
            }
        }
        return matches;
    }

    public static void main(String[] args) {
        CountOfMatchesInTournament obj = new CountOfMatchesInTournament();
        int n = 14;
        System.out.println(obj.numberOfMatches(n));
    }
}
