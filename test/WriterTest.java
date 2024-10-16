import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class WriterTest {

    final String TEST_FILE_NAME = "test.txt";
    Writer w = new Writer(TEST_FILE_NAME);
    Reader r = new Reader(TEST_FILE_NAME);

    @AfterEach
    public void cleanUp() {
        try {
            Path path = Paths.get(TEST_FILE_NAME);
            Files.deleteIfExists(path);
        } catch (IOException e) {
            System.err.println("Couldn't delete file");
        }
    }

    @Test
    public void testWriteToNewFile() {

        List <String> expectedContent = Arrays.asList("Hej", "Hejdå", "Felix");

        w.writeToFile("Hej");
        w.writeToFile("Hejdå");
        w.writeToFile("Felix");

        List<String> written = r.readFromFile();

        assertIterableEquals(written, expectedContent);
    }
}
