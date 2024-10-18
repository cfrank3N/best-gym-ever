package inputoutput;

import exceptions.BestGymException;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReaderTest {

    Reader r = new Reader("./test/data.txt");

    @Test
    public void testFromFile() throws BestGymException {
        //Creates a list of expected content to compare to the returned list from the readFromFile method.
        List <String> expectedContent = Arrays.asList("7703021234, Alhambra Aromes",
                "2024-07-01",
                "8204021234, Bear Belle",
                "2019-12-02",
                "8512021234, Chamade Coriola",
                "2018-03-12");
        //Read from file ./test/data.txt
        List <String> s = r.readFromFile();
        //Check to see if all elements in expectedContent and s are the same.
        assertIterableEquals(s, expectedContent);
        assertIterableEquals(expectedContent, s);
    }

    @Test
    public void testReadFromNonExistingFile() {
        Reader read = new Reader("nonexistingpath/tja.md");

        BestGymException e = assertThrows(BestGymException.class, read::readFromFile);
        assertEquals(FileNotFoundException.class, e.getCause().getClass());
    }

}
