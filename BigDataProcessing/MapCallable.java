package BigDataProcessing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class MapCallable implements Callable<Map<String, Integer>> {

    public final String filePath;
    public final Map<String, Integer> logMap;

    public MapCallable(String filePath) {
        this.filePath = filePath;
        this.logMap = new HashMap<>();
    }

    @Override
    public Map<String, Integer> call() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(this.filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String key = line.trim();
            int valueToInput = this.logMap.getOrDefault(key, 0) + 1;
            this.logMap.put(key, valueToInput);
        }
        reader.close();
        return this.logMap;
    }

}
