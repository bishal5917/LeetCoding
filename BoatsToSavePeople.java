import java.util.Arrays;

public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        // Lets just use a two pointer sorting approach
        Arrays.sort(people);
        int boats = 0;
        int rescued = 0;
        int i = 0;
        int j = people.length - 1;
        while (i < j) {
            if (people[i] + people[j] <= limit) {
                boats += 1;
                i += 1;
                j -= 1;
                rescued += 2;
            } else if (people[j] == limit) {
                boats += 1;
                j -= 1;
                rescued += 1;
            } else if (people[i] + people[j] > limit) {
                boats += 1;
                j -= 1;
                rescued += 1;
            }
        }
        // Now add the unrescued one if any to a single boat
        return boats + people.length - rescued;
    }

    public static void main(String[] args) {
        BoatsToSavePeople obj = new BoatsToSavePeople();
        int[] people = { 1, 2, 2, 3 };
        int limit = 3;
        System.out.println(obj.numRescueBoats(people, limit));
    }

}
