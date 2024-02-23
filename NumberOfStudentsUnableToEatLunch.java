import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class NumberOfStudentsUnableToEatLunch {

    public int countStudents(int[] students, int[] sandwiches) {
        // Lets initialize a student queue and sandwich stack
        int eaten = 0;
        Deque<Integer> stQueue = new ArrayDeque<>();
        Stack<Integer> swichStack = new Stack<>();
        // Lets add the sandwiches and students
        for (int sw = sandwiches.length - 1; sw >= 0; sw--) {
            // gotta add from the last
            swichStack.push(sandwiches[sw]);
        }
        // add the students
        for (int st : students) {
            stQueue.addLast(st);
        }
        System.out.println(Arrays.toString(students));
        System.out.println(Arrays.toString(sandwiches));
        // Now lets check until the stack is empty
        int noProgressCount = 0;
        while (!swichStack.isEmpty() && !stQueue.isEmpty()) {
            if (noProgressCount > students.length * 3) {
                // if theres no progress after this many times,we can break
                break;
            }
            int currStudent = stQueue.removeFirst();
            if (currStudent == swichStack.peek()) {
                // then he can eat
                eaten += 1;
                swichStack.pop();
            } else {
                // else just add the student to the end of the queue
                stQueue.addLast(currStudent);
                noProgressCount += 1;
            }
        }

        return students.length - eaten;
    }

    public static void main(String[] args) {
        NumberOfStudentsUnableToEatLunch obj = new NumberOfStudentsUnableToEatLunch();
        int[] students = { 1, 1, 1, 0, 0, 1 };
        int[] sandwiches = { 1, 0, 0, 0, 1, 1 };
        System.out.println(obj.countStudents(students, sandwiches));
    }
}
