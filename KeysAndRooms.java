import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> keys = new LinkedList<>();
        // First lets visit the first room
        visited.add(0);
        List<Integer> firstKeys = rooms.get(0);
        for (int key : firstKeys) {
            keys.offer(key);
        }
        while (!keys.isEmpty()) {
            int currKey = keys.poll();
            List<Integer> gotKeys = rooms.get(currKey);
            for (int key : gotKeys) {
                if (!visited.contains(key)) {
                    keys.offer(key);
                }
            }
            visited.add(currKey);
        }
        return visited.size() == rooms.size();
    }

    public static void main(String[] args) {
        KeysAndRooms obj = new KeysAndRooms();
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1, 3));
        rooms.add(Arrays.asList(3, 0, 1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(0));
        System.out.println(obj.canVisitAllRooms(rooms));
    }
}
