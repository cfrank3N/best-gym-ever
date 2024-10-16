import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class ReaderTest {

    Reader r = new Reader("./test/data.txt");

    //TODO: Testa setter och getter för lista fileData

    @Test
    public void testFromFile() {
        List <String> s = r.readFromFile();

        assertEquals("7703021234, Alhambra Aromes", s.getFirst());
        assertEquals("2019-12-02", s.get(3));
        assertEquals("2024-08-04", s.getLast());
        assertThrows(FileNotFoundException.class, () -> new Scanner(new File("Hej.txt")));
        assertNotEquals("Alhambra", s.getFirst());
    }

    @Test
    public void testSplitString() {
       String[] s = r.splitString("7703021234, Alhambra Aromes", ", ");

       assertEquals("7703021234",s[0]);
       assertEquals("Alhambra Aromes",s[1]);
    }

    @Test
    public void testParseStringToDate() {
        String date = "2024-08-04";
        LocalDate ld = LocalDate.of(2024, 8, 4);
        LocalDate ld2 = LocalDate.of(2025, 8, 4);
        LocalDate localDate = r.parseStringToDate(date);
        assertEquals(ld, localDate);
        assertThrows(DateTimeParseException.class, () -> LocalDate.parse("abc"));
        assertNotEquals(ld2, localDate);
    }

}
