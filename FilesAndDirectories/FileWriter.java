package FilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileWriter {

    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("./FilesAndDirectories/Files/Top5DJs.txt");
        List<String> djs = new ArrayList<>();
        djs.add("AVICII");
        djs.add("SKRILLEX");
        djs.add("MARTIN GARRIX");
        djs.add("LUCAS & STEVE");
        djs.add("KYGO");
        Files.write(filePath, djs);
    }
}
