import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DestinationCity {

    public String destCity(List<List<String>> paths) {
        HashMap<String, String> pathMap = new HashMap<>();
        // Now iterate over all the paths and add to the HashMap
        for (List<String> path : paths) {
            pathMap.put(path.get(0), path.get(1));
        }
        String startCity = paths.get(0).get(0);

        // haha just loop till the last city and return the city that has no child
        while (pathMap.get(startCity) != null) {
            startCity = pathMap.get(startCity);
        }
        return startCity;
    }

    public static void main(String[] args) {
        DestinationCity obj = new DestinationCity();
        List<List<String>> paths = new ArrayList<>();
        List<String> path1 = new ArrayList<>();
        path1.add("London");
        path1.add("New York");
        List<String> path2 = new ArrayList<>();
        path2.add("New York");
        path2.add("Lima");
        List<String> path3 = new ArrayList<>();
        path3.add("Lima");
        path3.add("Sao Paulo");
        paths.add(path1);
        paths.add(path2);
        paths.add(path3);
        System.out.println(obj.destCity(paths));
    }

}
