package FilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Predicate;

public class DirectoryScanRunner {

    public static void main(String[] args) throws IOException {
        // Files.list(Paths.get(".")).forEach(System.out::println);
        Path currentlyDir = Paths.get(".");

        // depth = signifies how much deep you wanna go in a directory
        Predicate<? super Path> predicate = path -> String.valueOf(path).contains(".java");

        // filter or returns that contains .java type
        Files.walk(currentlyDir, 1).filter(predicate).forEach(System.out::println);
    }
}