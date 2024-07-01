import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafx.util.Pair;

public class UndergroundSystem {

    HashMap<Integer, Pair<String, Integer>> startMap;
    HashMap<String, List<Integer>> endMap;

    public UndergroundSystem() {
        startMap = new HashMap<>();
        endMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        startMap.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        // Get the starting station of that person
        Pair<String, Integer> started = startMap.get(id);
        String startStation = started.getKey().toString();
        int startTime = Integer.valueOf(started.getValue().toString());
        String route = startStation + "-" + stationName;
        endMap.putIfAbsent(route, new ArrayList<>());
        endMap.get(route).add(t - startTime);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "-" + endStation;
        List<Integer> vals = endMap.get(route);
        double total = 0;
        for (int val : vals) {
            total += Double.valueOf(val);
        }
        double avg = (double) total / (double) vals.size();
        return avg;
    }

    public static void main(String[] args) {
        UndergroundSystem obj = new UndergroundSystem();
        obj.checkIn(45, "Leyton", 3);
        obj.checkIn(32, "Paradise", 8);
        obj.checkIn(27, "Leyton", 10);
        obj.checkOut(45, "Waterloo", 15);
        obj.checkOut(27, "Waterloo", 20);
        obj.checkOut(32, "Cambridge", 22);
        System.out.println(obj.getAverageTime("Paradise", "Cambridge"));
        System.out.println(obj.getAverageTime("Leyton", "Waterloo"));
        obj.checkIn(10, "Leyton", 24);
        System.out.println(obj.getAverageTime("Leyton", "Waterloo"));
        obj.checkOut(10, "Waterloo", 38);
        System.out.println(obj.getAverageTime("Leyton", "Waterloo"));
    }
}
