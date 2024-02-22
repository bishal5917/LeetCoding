import java.util.Arrays;

public class DividePlayersIntoTeams {

    public long dividePlayers(int[] skill) {
        long chemistry = 0;
        Arrays.sort(skill);
        int i = 0;
        int j = skill.length - 1;
        int currTotalSkill = skill[i] + skill[j];
        while (i < j) {
            if (skill[i] + skill[j] != currTotalSkill) {
                return -1;
            }
            chemistry = chemistry + skill[i] * skill[j];
            i += 1;
            j -= 1;
        }
        return chemistry;
    }

    public static void main(String[] args) {
        int[] skill = { 3, 2, 5, 1, 3, 4 };
        DividePlayersIntoTeams obj = new DividePlayersIntoTeams();
        System.out.println(obj.dividePlayers(skill));
    }
}
