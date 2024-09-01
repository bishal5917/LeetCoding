import java.util.ArrayList;
import java.util.List;

public class SnakeInMatrix {

    public int finalPositionOfSnake(int n, List<String> commands) {
        int r = 0;
        int c = 0;
        for (String command : commands) {
            if (command.equals("RIGHT")) {
                c++;
            } else if (command.equals("LEFT")) {
                c--;
            } else if (command.equals("DOWN")) {
                r++;
            } else if (command.equals("UP")) {
                r--;
            }
        }
        return (r * n) + c;
    }

    public static void main(String[] args) {
        SnakeInMatrix obj = new SnakeInMatrix();
        int n = 3;
        List<String> commands = new ArrayList<>();
        commands.add("DOWN");
        commands.add("RIGHT");
        commands.add("UP");
        System.out.println(obj.finalPositionOfSnake(n, commands));
    }

}
