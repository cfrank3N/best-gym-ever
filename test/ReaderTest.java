import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class ReaderTest {

    Reader r = new Reader("./test/data.txt");

    //TODO: Testa setter och getter för lista fileData

    @Test
    public void testFromFile() {
        List <String> expectedContent = Arrays.asList("7703021234, Alhambra Aromes",
                "2024-07-01",
                "8204021234, Bear Belle",
                "2019-12-02",
                "8512021234, Chamade Coriola",
                "2018-03-12");

        List <String> s = r.readFromFile();

        assertIterableEquals(s, expectedContent);
        assertThrows(FileNotFoundException.class, () -> new Scanner(new File("Hej.txt")));
    }

    @Test
    public void testSplitString() {
        String[] expectedContent = {"7703021234", "Alhambra Aromes"};
        String[] s = r.splitString("7703021234, Alhambra Aromes", ", ");

        assertArrayEquals(s, expectedContent);
    }

    @Test
    public void testParseStringToDate() {

        LocalDate ld = LocalDate.of(2024, 8, 4);
        LocalDate ld2 = LocalDate.of(2025, 8, 4);

        String date = "2024-08-04";
        LocalDate localDate = r.parseStringToDate(date);

        assertEquals(ld, localDate);
        assertThrows(DateTimeParseException.class, () -> LocalDate.parse("abc"));
        assertNotEquals(ld2, localDate);
    }

}
