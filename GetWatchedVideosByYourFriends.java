import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GetWatchedVideosByYourFriends {

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        // DOING A LEVEL ORDER BFS
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(id);
        visited.add(id);
        while (!queue.isEmpty() && level > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                // Now add all its neighbors
                int[] neighbors = friends[curr];
                // add all the nebs to the queue
                for (int neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            level -= 1;
        }
        HashSet<Integer> levelFriends = new HashSet<>();
        while (!queue.isEmpty()) {
            int val = queue.poll();
            levelFriends.add(val);
        }
        // NOW THOSE THAT ARE IN THE QUEUE ARE THE REQUIRED LEVEL FRIENDS
        // Now gotta count the frequency of the strings occured
        HashMap<String, Integer> bucket = new HashMap<>();
        for (int friend : levelFriends) {
            List<String> videos = watchedVideos.get(friend);
            for (String video : videos) {
                if (bucket.containsKey(video)) {
                    int prev = bucket.get(video);
                    bucket.put(video, prev + 1);
                } else {
                    bucket.put(video, 1);
                }
            }
        }
        List<String> ans = new ArrayList<>(bucket.keySet());

        // Sorting with comparators
        ans.sort((a, b) -> {
            int fa = bucket.get(a);
            int fb = bucket.get(b);
            if (fa != fb) {
                return fa - fb;
            } else {
                return a.compareTo(b);
            }
        });

        return ans;
    }

    public static void main(String[] args) {
        GetWatchedVideosByYourFriends obj = new GetWatchedVideosByYourFriends();
        List<List<String>> watchedVideos = new ArrayList<>();
        watchedVideos.add(Arrays.asList("A", "B"));
        watchedVideos.add(Arrays.asList("C"));
        watchedVideos.add(Arrays.asList("B", "C"));
        watchedVideos.add(Arrays.asList("D"));
        int[][] friends = { { 1, 2 }, { 0, 3 }, { 0, 3 }, { 1, 2 } };
        int id = 0;
        int level = 1;
        System.out.println(obj.watchedVideosByFriends(watchedVideos, friends, id, level));
    }
}
