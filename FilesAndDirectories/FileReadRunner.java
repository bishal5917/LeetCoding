package FilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReadRunner {

    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("./FilesAndDirectories/Files/test.txt");
        // This will read all the file at once and put each line as string
        // and append it in lines arraylist.
        List<String> lines = Files.readAllLines(filePath);
        System.out.println(lines);
        // This approach is quite time consuming and isnot suitable for cases where
        // there are millions
        // of lines in a file
        // So we use Streams
        // Streams process each line one by one - It doesnot try to read all the file at
        // once
        Files.lines(filePath).map(String::toLowerCase).filter(str -> str.contains("a")).forEach(System.out::println);
    }
}
