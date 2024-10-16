import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WriterTest {

    Writer w = new Writer();
    Reader r = new Reader();

    @Test
    public void testWriteToNewFile() {

        w.writeToFile("test.txt", "Hej");
        //w.writeToFile("./test/visitors.txt", "Hejdå");

        //List<String> written = r.readFromFile("./test/visitors.txt");

        //assertEquals("Namn: Adam Frank Personnummer: 960222xxxx Datum för besök: 2024-10-16", written.getFirst());
    }

    @Test
    public void testWriteToNewFileAppen() {

    }

}
