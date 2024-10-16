import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class ReaderTest {

    Reader r = new Reader();

    @Test
    public void testFromFile() {
        List <String> s = r.readFromFile("./test/data.txt");

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

}
