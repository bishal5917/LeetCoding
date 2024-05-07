import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumGeneticMutation {

    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> bankSet = new HashSet<>();
        for (String gene : bank) {
            bankSet.add(gene);
        }
        return bfsHelper(startGene, endGene, bankSet);
    }

    private int bfsHelper(String start, String target, HashSet<String> bank) {
        int count = 0;
        List<Character> mutations = new ArrayList<>(
                Arrays.asList('A', 'C', 'G', 'T'));
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(start);
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int x = 0; x < size; x++) {
                String curr = queue.poll();
                if (curr.equals(target)) {
                    return count;
                }
                char[] currGene = curr.toCharArray();
                for (int i = 0; i < currGene.length; i++) {
                    char currChar = currGene[i];
                    // Now change this to all four possibilities
                    for (char c : mutations) {
                        // Now change and check if its in bank
                        currGene[i] = c;
                        String next = new String(currGene);
                        if (!visited.contains(next) && bank.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                        // change it to prev again
                        currGene[i] = currChar;
                    }
                    currGene = curr.toCharArray();
                }
            }
            count += 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumGeneticMutation obj = new MinimumGeneticMutation();
        String startGene = "AACCGGTT";
        String endGene = "AACCGCTA";
        String[] bank = { "AACCGGTA", "AACCGCTA", "AAACGGTA" };
        System.out.println(obj.minMutation(startGene, endGene, bank));
    }
}
