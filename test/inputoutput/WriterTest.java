package inputoutput;

import exceptions.BestGymException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    public void testWriteToNewFile() throws BestGymException {

        List<String> expectedContent = Arrays.asList("Hej", "Hejdå", "Felix");

        w.writeToFile("Hej");
        w.writeToFile("Hejdå");
        w.writeToFile("Felix");

        List<String> written = r.readFromFile();

        assertIterableEquals(written, expectedContent);
    }

    @Test
    public void testWriteToInvalidPathShouldThrow() {

        Writer write = new Writer("mappsomintefinns/hej.txt");
        BestGymException e = assertThrows(BestGymException.class, () -> write.writeToFile("Test failed"));
        assertEquals(FileNotFoundException.class, e.getCause().getClass());
    }
}
